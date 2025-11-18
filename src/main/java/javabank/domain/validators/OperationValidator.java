package javabank.domain.validators;

import javabank.domain.banking.operations.Operation;

import java.text.ParseException;

// Operation 엔티티의 유효성을 검사하는 클래스입니다.
public class OperationValidator implements Validator<Operation> {

    /**
     * Operation 엔티티의 유효성을 검사합니다.
     *
     * @param entity Operation, 유효성을 검사할 엔티티
     * @throws ValidationException, 유효성 검사 실패 시 발생하는 예외
     */
    @Override
    public void validate(Operation entity) throws ValidationException {
        // TODO: 거래(Operation) 유효성 검사 구현 필요
    }
}