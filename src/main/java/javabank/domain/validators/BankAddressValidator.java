package javabank.domain.validators;

import javabank.domain.BankAddress;

// BankAddress 엔티티의 유효성을 검사하는 클래스입니다.
public class BankAddressValidator implements Validator<BankAddress> {
    /**
     * BankAddress 엔티티의 유효성을 검사합니다.
     *
     * @param entity BankAddress, 유효성을 검사할 엔티티
     * @throws ValidationException, BankAddress가 유효하지 않을 경우
     */
    @Override
    public void validate(BankAddress entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "은행 주소 ID는 음수일 수 없습니다!\n";
        }
        if (entity.getStreetName().matches("[ ]*")) {
            errors += "은행 주소의 도로명은 비어 있을 수 없습니다!\n";
        }
        if (entity.getNumber() < 0) {
            errors += "은행 주소의 건물 번호는 음수일 수 없습니다!\n";
        }
        if (entity.getCityName().matches("[ ]*")) {
            errors += "은행 주소의 도시명은 비어 있을 수 없습니다!\n";
        }
        if (!entity.getCountyName().matches("^[a-zA-Z\\s]*$")) {
            errors += "은행 주소의 군/지역명은 비어 있을 수 없으며 숫자를 포함할 수 없습니다!\n";
        }
        if (entity.getPostalCode() < 100000 || entity.getPostalCode() > 999999) {
            errors += "은행 주소의 우편번호는 6자리 양수여야 합니다!\n";
        }
        if (!entity.getCountryName().matches("^[a-zA-Z\\s]*$")) {
            errors += "은행 주소의 국가명은 비어 있을 수 없으며 숫자를 포함할 수 없습니다!";
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}