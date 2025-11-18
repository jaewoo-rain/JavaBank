package javabank.domain.validators;

import javabank.domain.BankAccount;
import javabank.domain.Client;
import javabank.utils.validators.CNPValidator;
import javabank.utils.validators.EmailValidator;
import javabank.utils.validators.TelephoneNumberValidator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Client 엔티티의 유효성을 검사하는 클래스입니다.
public class ClientValidator implements Validator<Client> {
    /**
     * Client 엔티티의 유효성을 검사합니다.
     *
     * @param entity Client, 유효성을 검사할 엔티티
     * @throws ValidationException, Client가 유효하지 않을 경우
     * @throws ParseException, CNP가 유효하지 않을 경우
     */
    @Override
    public void validate(Client entity) throws ValidationException, ParseException {
        String errors = "";

        if (entity.getId() < 0) {
            errors += "고객 ID는 음수일 수 없습니다!\n";
        }
        if (!entity.getFirstName().matches("^[a-zA-Z\\s]*$")) {
            errors += "고객의 이름은 비어 있을 수 없으며 숫자를 포함할 수 없습니다!\n";
        }
        if (!entity.getLastName().matches("^[a-zA-Z\\s]*$")) {
            errors += "고객의 성은 비어 있을 수 없으며 숫자를 포함할 수 없습니다!\n";
        }
        if (!CNPValidator.validateCNP(entity.getCNP())) {
            errors += "고객의 주민등록번호(CNP)가 유효하지 않습니다!\n";
        }
        if (!TelephoneNumberValidator.validateTelephoneNumber(entity.getTelephoneNumber())) {
            errors += "전화번호가 유효하지 않습니다!\n";
        }
        if(!EmailValidator.validateEmail(entity.getEmail())) {
            errors += "이메일 주소가 유효하지 않습니다!\n";
        }

        // TODO: 고객 로그인 정보(credentials) 유효성 검사 구현 필요

        try {
            List<BankAccount> bankAccounts = new ArrayList<BankAccount>((Collection<? extends BankAccount>) entity.getBankAccounts().findAll());
            BankAccountValidator bankAccountValidator = new BankAccountValidator();

            for (BankAccount bankAccount: bankAccounts) {
                bankAccountValidator.validate(bankAccount);
            }

        }
        catch (ValidationException validationException) {
            errors += validationException.toString();
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}