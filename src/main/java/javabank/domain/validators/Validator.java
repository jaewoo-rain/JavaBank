package javabank.domain.validators;

import java.text.ParseException;

// 제네릭 타입 E의 엔티티에 대한 유효성 검사를 수행하는 인터페이스입니다.
public interface Validator<E> {
    /**
     * 주어진 엔티티의 유효성을 검사하는 추상 메서드입니다.
     * @param entity E, 유효성을 검사할 엔티티
     * @throws ValidationException, 유효성 검사 실패 시 발생하는 예외
     * @throws ParseException, 파싱 오류 발생 시 발생하는 예외
     */
    void validate(E entity) throws ValidationException, ParseException;
}