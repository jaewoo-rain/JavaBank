package javabank.domain.validators;

import javabank.domain.BankBranch;
import javabank.domain.Client;
import javabank.utils.validators.EmailValidator;
import javabank.utils.validators.TelephoneNumberValidator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// BankBranch 엔티티의 유효성을 검사하는 클래스입니다.
public class BankBranchValidator implements Validator<BankBranch> {
    /**
     * BankBranch 엔티티의 유효성을 검사합니다.
     *
     * @param entity BankBranch, 유효성을 검사할 엔티티
     * @throws ValidationException, BankBranch가 유효하지 않을 경우
     */
    @Override
    public void validate(BankBranch entity) throws ValidationException {
        String errors = "";

        if (entity.getBicCode().matches("[ ]*")) {
            errors += "BIC 코드는 비어 있을 수 없습니다!\n";
        }
        if (entity.getSwiftCode().matches("[ ]*")) {
            errors += "SWIFT 코드는 비어 있을 수 없습니다!\n";
        }

        try {
            BankAddressValidator bankAddressValidator = new BankAddressValidator();
            bankAddressValidator.validate(entity.getBankAddress());
        }
        catch (ValidationException validationException) {
            errors += validationException.toString() + "\n";
        }

        if (!TelephoneNumberValidator.validateTelephoneNumber(entity.getBankTelephoneNumber())) {
            errors += "전화번호가 유효하지 않습니다!\n";
        }
        if (!EmailValidator.validateEmail(entity.getBankEmail())) {
            errors += "이메일 주소가 유효하지 않습니다!\n";
        }

        try {
            List<Client> clients = new ArrayList<Client>((Collection<? extends Client>) entity.getClients().findAll());
            ClientValidator clientValidator = new ClientValidator();

            for (Client client : clients) {
                clientValidator.validate(client);
            }
        }
        catch (ValidationException | ParseException validationException) {
            errors += validationException;
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }

    }
}