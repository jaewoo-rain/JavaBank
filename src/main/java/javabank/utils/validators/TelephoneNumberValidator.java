package javabank.utils.validators;

// 전화번호 형식의 유효성을 검사하는 유틸리티 클래스입니다.
public class TelephoneNumberValidator {
    // 다양한 국제 및 국내 전화번호 형식을 포괄하는 정규 표현식입니다.
    private static final String regexTelephoneNumber = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

    /**
     * 주어진 전화번호 문자열의 형식이 유효한지 검사합니다.
     * @param telephoneNumber 검사할 전화번호 문자열
     * @return 전화번호 형식이 유효하면 true, 그렇지 않으면 false
     */
    public static boolean validateTelephoneNumber(String telephoneNumber) {
        return telephoneNumber.matches(regexTelephoneNumber);
    }
}