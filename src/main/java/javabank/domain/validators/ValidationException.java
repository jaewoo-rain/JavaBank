package javabank.domain.validators;

@SuppressWarnings("serial")
// 유효성 검사 과정에서 발생하는 예외를 나타내는 클래스입니다.
public class ValidationException extends RuntimeException{
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}