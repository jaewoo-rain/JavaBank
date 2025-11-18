package javabank.utils.validators;

import javabank.domain.Card;

import java.text.SimpleDateFormat;
import java.util.Date;

// 카드 정보(번호, 유효기간)의 유효성을 검사하는 유틸리티 클래스입니다.
public class CardDetailsValidator {
    /**
     * 카드 번호와 유효기간의 유효성을 모두 검사합니다.
     * @param card 검사할 카드 객체
     * @return 카드 번호와 유효기간이 모두 유효하면 true, 그렇지 않으면 false
     */
    public static boolean validateCard(Card card) {
        boolean validCardNumber = validateCardNumber(card.getCardNumber());
        boolean validExpiryDate = validateExpiryDate(card.getValidThru());
        return validCardNumber && validExpiryDate;
    }

    /**
     * 카드 번호의 유효성을 Luhn 알고리즘을 사용하여 검사합니다.
     * @param number 검사할 카드 번호 문자열
     * @return 카드 번호가 유효하면 true, 그렇지 않으면 false
     */
    public static boolean validateCardNumber(String number) {
        int[] ints = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            ints[i] = Integer.parseInt(number.substring(i, i + 1));
        }

        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }

        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }

        return sum % 10 == 0;
    }

    /**
     * 카드의 유효기간이 만료되었는지 확인합니다.
     * @param validThru 검사할 카드의 유효기간
     * @return 유효기간이 현재 날짜 이전이면 true (유효함), 그렇지 않으면 false
     */
    public static boolean validateExpiryDate(Date validThru) {
        Date currDate = new Date(System.currentTimeMillis());
        // 버그 수정: 카드의 유효기간은 현재 날짜보다 이후여야 합니다.
        // 원래 코드: return currDate.after(validThru);
        return currDate.before(validThru);
    }
}