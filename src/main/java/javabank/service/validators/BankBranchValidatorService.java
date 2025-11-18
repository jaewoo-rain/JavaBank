package javabank.service.validators;

import javabank.domain.BankBranch;
import javabank.domain.validators.ValidationException;

// BankBranch 엔티티에 대한 서비스 레벨의 유효성 검사를 수행하는 클래스입니다.
public class BankBranchValidatorService implements ValidatorService<BankBranch> {
    /**
     * BankBranch 엔티티 추가 시 유효성을 검사합니다.
     *
     * @param entity BankBranch, 유효성을 검사할 엔티티
     * @throws ValidationException, 추가하려는 은행 지점이 이미 존재할 경우
     */
    @Override
    public void validateAdd(BankBranch entity) throws ValidationException {
        if (entity != null) {
            throw new ValidationException("추가하려는 은행 지점이 이미 존재합니다!");
        }
    }

    /**
     * BankBranch 엔티티 삭제 시 유효성을 검사합니다.
     *
     * @param entity BankBranch, 유효성을 검사할 엔티티
     * @throws ValidationException, 삭제하려는 은행 지점이 존재하지 않을 경우
     */
    @Override
    public void validateDelete(BankBranch entity) throws ValidationException {
        if (entity == null) {
            throw new ValidationException("삭제하려는 은행 지점이 존재하지 않습니다!");
        }
    }
}