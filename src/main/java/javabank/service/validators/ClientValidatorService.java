package javabank.service.validators;

import javabank.domain.Client;
import javabank.domain.validators.ValidationException;

// Client 엔티티에 대한 서비스 레벨의 유효성 검사를 수행하는 클래스입니다.
public class ClientValidatorService implements ValidatorService<Client> {
    /**
     * Client 엔티티 추가 시 유효성을 검사합니다.
     * @param entity Client, 유효성을 검사할 엔티티
     * @throws ValidationException, 추가하려는 클라이언트가 이미 존재할 경우
     */
    @Override
    public void validateAdd(Client entity) throws ValidationException {
        if (entity != null) {
            throw new ValidationException("추가하려는 클라이언트가 이미 존재합니다!");
        }
    }

    /**
     * Client 엔티티 삭제 시 유효성을 검사합니다.
     * @param entity Client, 유효성을 검사할 엔티티
     * @throws ValidationException, 삭제하려는 클라이언트가 존재하지 않을 경우
     */
    @Override
    public void validateDelete(Client entity) throws ValidationException {
        if (entity == null) {
            throw new ValidationException("삭제하려는 클라이언트가 존재하지 않습니다!");
        }
    }
}