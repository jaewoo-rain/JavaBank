package javabank.domain;

import java.util.Date;
import java.util.Objects;

// 카드 정보를 담는 엔티티 클래스입니다.
public class Card extends Entity<Long>{
    private String cardNumber; // 카드 번호
    private String cardHolder; // 카드 소유자 이름
    private Date validThru;    // 카드 유효 기간
    private int cvvCode;       // CVV 코드
    private int PIN;           // PIN 번호

    /**
     * 새로운 Card 객체를 생성하는 생성자입니다.
     * @param cardNumber String, 카드의 번호
     * @param cardHolder String, 카드의 소유자 이름
     * @param validThru Date, 카드의 유효 기간
     * @param cvvCode int, 카드의 CVV 코드
     * @param PIN int, 카드의 PIN 번호
     */
    public Card(String cardNumber, String cardHolder, Date validThru, int cvvCode, int PIN) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.validThru = validThru;
        this.cvvCode = cvvCode;
        this.PIN = PIN;
    }

    /**
     * 카드의 번호를 반환합니다.
     * @return String, 카드의 번호
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 카드의 번호를 설정합니다.
     * @param cardNumber String, 새로 설정할 카드의 번호
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 카드의 소유자 이름을 반환합니다.
     * @return String, 카드의 소유자 이름
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * 카드의 소유자 이름을 설정합니다.
     * @param cardHolder String, 새로 설정할 카드의 소유자 이름
     */
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * 카드의 유효 기간을 반환합니다.
     * @return Date, 카드의 유효 기간
     */
    public Date getValidThru() {
        return validThru;
    }

    /**
     * 카드의 유효 기간을 설정합니다.
     * @param validThru Date, 새로 설정할 카드의 유효 기간
     */
    public void setValidThru(Date validThru) {
        this.validThru = validThru;
    }

    /**
     * 카드의 CVV 코드를 반환합니다.
     * @return int, 카드의 CVV 코드
     */
    public int getCvvCode() {
        return cvvCode;
    }

    /**
     * 카드의 CVV 코드를 설정합니다.
     * @param cvvCode int, 새로 설정할 카드의 CVV 코드
     */
    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    /**
     * 카드의 PIN 번호를 반환합니다.
     * @return int, 카드의 PIN 번호
     */
    public int getPIN() {
        return PIN;
    }

    /**
     * 카드의 PIN 번호를 설정합니다.
     * @param PIN int, 새로 설정할 카드의 PIN 번호
     */
    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    /**
     * Card 객체의 문자열 표현을 반환합니다.
     * @return String, Card 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "Card{" +
                "ID='" + getId() + "'" +
                ", cardNumber='" + cardNumber + "'" +
                ", cardHolder='" + cardHolder + "'" +
                ", validThru=" + validThru +
                ", cvvCode=" + cvvCode +
                ", PIN=" + PIN +
                '}';
    }

    /**
     * 두 Card 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 모든 필드가 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card that = (Card) obj;
        return cvvCode == that.cvvCode && PIN == that.PIN && cardNumber.equals(that.cardNumber) && cardHolder.equals(that.cardHolder) && validThru.equals(that.validThru);
    }

    /**
     * Card 객체의 해시코드를 반환합니다.
     * @return int, Card 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardHolder, validThru, cvvCode, PIN);
    }
}