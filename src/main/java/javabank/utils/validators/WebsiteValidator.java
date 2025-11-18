package javabank.utils.validators;

// 웹사이트 URL 형식의 유효성을 검사하는 유틸리티 클래스입니다.
public class WebsiteValidator {
    // 일반적인 웹사이트 URL 형식을 확인하는 정규 표현식입니다.
    private static final String regexWebsite = "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";

    /**
     * 주어진 웹사이트 URL 문자열의 형식이 유효한지 검사합니다.
     * @param website 검사할 웹사이트 URL 문자열
     * @return URL 형식이 유효하면 true, 그렇지 않으면 false
     */
    public static boolean validateWebsite(String website) {
        return website.matches(regexWebsite);
    }
}