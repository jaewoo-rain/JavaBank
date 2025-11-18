package javabank.utils.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// 루마니아 개인 숫자 코드(CNP)의 유효성을 검사하는 유틸리티 클래스입니다.
public class CNPValidator {
    private static final int cnpLength = 13; // CNP의 길이
    private static final SimpleDateFormat cnpDateFormat = new SimpleDateFormat("yyMMdd"); // CNP 내 날짜 형식
    // CNP 검증을 위한 가중치 배열
    private static final int[] defaultCNP = new int[] {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};

    /**
     * CNP 문자열을 숫자 배열로 변환합니다.
     * @param cnpAsString 검사할 CNP 문자열
     * @return 변환된 숫자 배열. 숫자가 아닌 문자가 포함된 경우 null을 반환하여 실패 처리합니다.
     */
    private static int[] getCNPDigits(String cnpAsString) {
        if (cnpAsString.length() != cnpLength) {
            return null;
        }
        int[] digits = new int[cnpLength];
        for (int i = 0; i < cnpLength; i++) {
            char digit = cnpAsString.charAt(i);
            if (!Character.isDigit(digit)) {
                return null;
            }
            digits[i] = Character.digit(digit, 10);
        }
        return digits;
    }

    /**
     * 루마니아 CNP의 공식 검증 알고리즘에 따라 제어 합계를 계산합니다.
     * @param cnpDigits CNP 숫자 배열
     * @return 계산된 제어 합계. 입력이 null이면 -1을 반환합니다.
     */
    private static int getControlSum(int[] cnpDigits) {
        if (cnpDigits == null) {
            return -1;
        }
        int controlSum = 0;
        for (int i = 0; i < cnpLength - 1 ; i++) {
            controlSum += cnpDigits[i] * defaultCNP[i];
        }

        controlSum %= 11;
        if (controlSum == 10) {
            return 1;
        }
        return controlSum;
    }

    /**
     * CNP 문자열의 전체 유효성을 검사합니다.
     * @param cnpAsString 검사할 CNP 문자열
     * @return CNP가 유효하면 true, 그렇지 않으면 false
     * @throws ParseException 날짜 파싱 중 오류 발생 시
     */
    public static boolean validateCNP(String cnpAsString) throws ParseException {
        int[] cnpDigits = getCNPDigits(cnpAsString);
        if (cnpDigits == null) {
            return false;
        }

        int controlSum = getControlSum(cnpDigits);
        if (controlSum == -1) {
            return false;
        }

        // 마지막 제어 숫자가 일치하는지 확인
        if (controlSum != cnpDigits[cnpLength - 1]) {
            return false;
        }

        // 성별 및 세기(century)를 나타내는 첫 번째 숫자를 기반으로 생년월일 유효성 검사
        Calendar cal = new GregorianCalendar();
        try {
            // yyMMdd 형식의 날짜가 유효한지 엄격하게 검사
            cnpDateFormat.setLenient(false);
            Date birthDate = cnpDateFormat.parse(cnpAsString.substring(1, 7));
            cal.setTime(birthDate);
        } catch (ParseException e) {
            return false; // 유효하지 않은 날짜 형식
        }

        int firstDigit = cnpDigits[0];
        int year = cal.get(Calendar.YEAR);

        // 1900년대 출생자 (1, 2), 2000년대 출생자 (5, 6) 등 세기 확인
        if (year >= 2000 && (firstDigit != 5 && firstDigit != 6)) {
            return false;
        } else if (year < 2000 && (firstDigit != 1 && firstDigit != 2)) {
            // 다른 세기 (예: 1800년대)에 대한 규칙도 추가할 수 있습니다.
            // 여기서는 1900년대와 2000년대만 고려합니다.
            return false;
        }

        return true;
    }
}