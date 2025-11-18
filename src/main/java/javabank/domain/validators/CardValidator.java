package javabank.domain.validators;

import javabank.domain.Card;
import javabank.utils.validators.CardDetailsValidator;

// Card 엔티티의 유효성을 검사하는 클래스입니다.
public class CardValidator implements Validator<Card> {
    /**
     * Card 엔티티의 유효성을 검사합니다.
     *
     * @param entity Card, 유효성을 검사할 엔티티
     * @throws ValidationException, Card가 유효하지 않을 경우
     */
    @Override
    public void validate(Card entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0) {
            errors += "카드 ID는 음수일 수 없습니다!\n";
        }
        if (!CardDetailsValidator.validateCard(entity)) {
            errors += "카드 정보가 유효하지 않습니다!\n";
        }
        if (!entity.getCardHolder().matches("^[a-zA-Z\\s]*$")) {
            errors += "카드 소유자 이름은 비어 있을 수 없으며 숫자를 포함할 수 없습니다!\n";
        }
        if (entity.getCvvCode() < 100 || entity.getCvvCode() > 999) {
            errors += "CVV 코드는 세 자리 양수여야 합니다!\n";
        }
        if (entity.getPIN() < 1000) {
            errors += "카드 PIN 코드는 4자리 이상의 양수여야 합니다!";
        }

        if(errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}