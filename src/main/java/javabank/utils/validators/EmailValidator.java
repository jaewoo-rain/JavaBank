package javabank.utils.validators;

// 이메일 주소의 형식 유효성을 검사하는 유틸리티 클래스입니다.
public class EmailValidator {
    // 이메일 주소의 기본적인 형식을 확인하는 정규 표현식입니다. (예: "something@something")
    private static final String regexEmail = "^(.+)@(.+)$";

    /**
     * 주어진 이메일 주소 문자열의 형식이 유효한지 검사합니다.
     * @param email 검사할 이메일 주소 문자열
     * @return 이메일 형식이 유효하면 true, 그렇지 않으면 false
     */
    public static boolean validateEmail(String email) {
        return email.matches(regexEmail);
    }
}