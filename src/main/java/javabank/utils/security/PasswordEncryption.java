package javabank.utils.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

// 비밀번호 암호화를 처리하는 유틸리티 클래스입니다.
public class PasswordEncryption {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000; // 해싱 반복 횟수
    private static final int KEY_LENGTH = 256; // 키 길이

    /**
     * 주어진 길이의 솔트(salt) 값을 생성합니다.
     * @param length int, 생성할 솔트 값의 길이
     * @return String, 생성된 솔트 값
     */
    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for(int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    /**
     * PBKDF2 알고리즘을 사용하여 비밀번호를 해싱합니다.
     * @param password char[], 클라이언트가 제공한 비밀번호
     * @param salt byte[], 솔트 값
     * @return byte[], 암호화된 비밀번호
     * @throws AssertionError 암호화된 비밀번호를 생성하지 못한 경우
     */
    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);

        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return secretKeyFactory.generateSecret(spec).getEncoded();
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("비밀번호 해싱 중 오류 발생: " + e.getMessage(), e);
        }
        finally {
            spec.clearPassword();
        }
    }

    /**
     * 솔트를 사용하여 안전한 비밀번호를 생성하고 Base64로 인코딩합니다.
     * @param password String, 클라이언트가 제공한 암호화되지 않은 비밀번호
     * @param salt String, 솔트 값
     * @return String, 생성된 안전한 비밀번호
     */
    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

        returnValue = Base64.getEncoder().encodeToString(securePassword);
        return returnValue;
    }

    /**
     * 로그인 과정에서 제공된 비밀번호와 저장된 비밀번호를 확인합니다.
     * @param providedPassword String, 클라이언트가 제공한 비밀번호
     * @param securedPassword String, 데이터베이스에 저장된 암호화된 비밀번호
     * @param salt String, 데이터베이스에 저장된 솔트 값
     * @return  true, 두 비밀번호가 일치하는 경우
     *          false, 그렇지 않은 경우
     */
    public static boolean verifyClientPassword(String providedPassword, String securedPassword, String salt) {
        boolean returnValue = false;

        // 동일한 솔트로 새로운 보안 비밀번호 생성
        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        // 두 비밀번호가 같은지 확인
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        return returnValue;
    }

}