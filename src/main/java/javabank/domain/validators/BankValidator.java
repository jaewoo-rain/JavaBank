package javabank.domain.validators;

import javabank.domain.Bank;
import javabank.domain.BankBranch;
import javabank.utils.validators.EmailValidator;
import javabank.utils.validators.TelephoneNumberValidator;
import javabank.utils.validators.WebsiteValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Bank 엔티티의 유효성을 검사하는 클래스입니다.
public class BankValidator implements Validator<Bank> {
    /**
     * Bank 엔티티의 유효성을 검사합니다.
     *
     * @param entity Bank, 유효성을 검사할 엔티티
     * @throws ValidationException, Bank가 유효하지 않을 경우
     */
    @Override
    public void validate(Bank entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "은행 주소 ID는 음수일 수 없습니다!\n";
        }
        if (!entity.getBankName().matches("^[a-zA-Z\\s]*$")) {
            errors += "은행 이름은 비어 있을 수 없으며 숫자를 포함할 수 없습니다!\n";
        }

        try {
            BankAddressValidator bankAddressValidator = new BankAddressValidator();
            bankAddressValidator.validate(entity.getHeadquartersAddress());
        }
        catch (ValidationException validationException) {
            errors += validationException.toString() + "\n";
        }

        if (!TelephoneNumberValidator.validateTelephoneNumber(entity.getHqTelephoneNumber())) {
            errors += "전화번호가 유효하지 않습니다!\n";
        }
        if (!EmailValidator.validateEmail(entity.getHqEmail())) {
            errors += "이메일 주소가 유효하지 않습니다!\n";
        }
        if (!WebsiteValidator.validateWebsite(entity.getWebsite())) {
            errors += "URL 주소가 유효하지 않습니다!";
        }

        try {
            List<BankBranch> bankBranches = new ArrayList<BankBranch>((Collection<? extends BankBranch>) entity.getBankBranches().findAll());
            BankBranchValidator bankBranchValidator = new BankBranchValidator();

            for (BankBranch bankBranch : bankBranches) {
                bankBranchValidator.validate(bankBranch);
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