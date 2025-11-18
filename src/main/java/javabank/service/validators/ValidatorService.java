package javabank.service.validators;

import javabank.domain.validators.ValidationException;

// 서비스 레벨에서 엔티티의 유효성 검사를 정의하는 인터페이스입니다.
public interface ValidatorService<T> {
    /**
     * 엔티티 추가 시 유효성을 검사하는 추상 메서드입니다.
     * @param entity T, 유효성을 검사할 엔티티
     * @throws ValidationException, 유효성 검사 실패 시
     */
    void validateAdd(T entity) throws ValidationException;

    /**
     * 엔티티 삭제 시 유효성을 검사하는 추상 메서드입니다.
     * @param entity T, 유효성을 검사할 엔티티
     * @throws ValidationException, 유효성 검사 실패 시
     */
    void validateDelete(T entity) throws ValidationException;
}