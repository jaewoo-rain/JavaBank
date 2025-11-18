package javabank.domain.validators;

import javabank.domain.Card;
import javabank.domain.Tuple;
import javabank.domain.banking.operations.Operation;
import org.apache.commons.validator.routines.IBANValidator;
import javabank.domain.BankAccount;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// BankAccount 엔티티의 유효성을 검사하는 클래스입니다.
public class BankAccountValidator implements Validator<BankAccount> {
    /**
     * BankAccount 엔티티의 유효성을 검사합니다.
     *
     * @param entity BankAccount, 유효성을 검사할 엔티티
     * @throws ValidationException, BankAccount가 유효하지 않을 경우
     */
    @Override
    public void validate(BankAccount entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "은행 계좌 ID는 음수일 수 없습니다!\n";
        }
        if (!IBANValidator.getInstance().isValid(entity.getIbanCode())) {
            errors += "IBAN 코드가 유효하지 않습니다!";
        }

        try {
            List<Card> validCards = new ArrayList<>((Collection<? extends Card>) entity.getValidCards().findAll());
            CardValidator cardValidator = new CardValidator();
            for (Card card : validCards) {
                cardValidator.validate(card);
            }

            List<Tuple<Operation, Card>> bankingOperations = new ArrayList<>((Collection<? extends Tuple<Operation, Card>>) entity.getBankingOperations().findAll());
            Validator<Tuple<Operation, Card>> bankingOperationValidator = BankAccountValidator::validateBankingOperation;
            for (Tuple<Operation, Card> bankingOperation : bankingOperations) {
                bankingOperationValidator.validate(bankingOperation);
            }
        }
        catch (ValidationException | ParseException validationException) {
            errors += validationException.toString();
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }

    /**
     * 은행 거래(Operation)와 카드(Card)의 튜플에 대한 유효성을 검사합니다.
     * @param entity Operation과 Card의 튜플
     */
    public static void validateBankingOperation(Tuple<Operation, Card> entity) {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "은행 계좌 ID는 음수일 수 없습니다!\n";
        }

        try {
            // OperationValidator
            OperationValidator operationValidator = new OperationValidator();
            operationValidator.validate(entity.getLeftEntity());

            // CardValidator
            CardValidator cardValidator = new CardValidator();
            cardValidator.validate(entity.getRightEntity());
        }
        catch (ValidationException validationException) {
            errors += validationException.toString();
        }

        if(errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}