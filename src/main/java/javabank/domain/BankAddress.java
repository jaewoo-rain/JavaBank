package javabank.domain;

import java.util.Objects;

// 은행 주소를 담는 엔티티 클래스입니다.
public class BankAddress extends Entity<Long>{
    private String streetName; // 도로명
    private int number; // 건물 번호
    private String cityName; // 도시명
    private String countyName; // 군/지역명
    private int postalCode; // 우편번호
    private String countryName; // 국가명

    /**
     * 새로운 BankAddress 객체를 생성하는 생성자입니다.
     * @param streetName String, 은행이 위치한 도로명
     * @param number int, 은행 건물의 번호
     * @param cityName String, 은행이 위치한 도시명
     * @param countyName String, 은행이 위치한 군/지역명
     * @param postalCode int, 은행의 우편번호
     * @param countryName String, 은행이 위치한 국가명
     */
    public BankAddress(String streetName, int number, String cityName, String countyName, int postalCode, String countryName) {
        this.streetName = streetName;
        this.number = number;
        this.cityName = cityName;
        this.countyName = countyName;
        this.postalCode = postalCode;
        this.countryName = countryName;
    }

    /**
     * 은행이 위치한 도로명을 반환합니다.
     * @return String, 도로명
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * 은행이 위치한 도로명을 설정합니다.
     * @param streetName String, 새로 설정할 도로명
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * 은행 건물의 번호를 반환합니다.
     * @return int, 건물 번호
     */
    public int getNumber() {
        return number;
    }

    /**
     * 은행 건물의 번호를 설정합니다.
     * @param number int, 새로 설정할 건물 번호
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 은행이 위치한 도시명을 반환합니다.
     * @return String, 도시명
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 은행이 위치한 도시명을 설정합니다.
     * @param cityName String, 새로 설정할 도시명
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 은행이 위치한 군/지역명을 반환합니다.
     * @return String, 군/지역명
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * 은행이 위치한 군/지역명을 설정합니다.
     * @param countyName String, 새로 설정할 군/지역명
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /**
     * 은행의 우편번호를 반환합니다.
     * @return int, 우편번호
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * 은행의 우편번호를 설정합니다.
     * @param postalCode int, 새로 설정할 우편번호
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 은행이 위치한 국가명을 반환합니다.
     * @return String, 국가명
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * 은행이 위치한 국가명을 설정합니다.
     * @param countryName String, 새로 설정할 국가명
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * BankAddress 객체의 문자열 표현을 반환합니다.
     * @return String, BankAddress 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "BankAddress{" +
                "ID='" + getId() + "'" + 
                ", streetName='" + streetName + "'" + 
                ", number=" + number + 
                ", cityName='" + cityName + "'" + 
                ", countyName='" + countyName + "'" + 
                ", postalCode=" + postalCode + 
                ", countryName='" + countryName + "'" + 
                '}';
    }

    /**
     * 두 BankAddress 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 주소의 모든 필드가 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAddress that = (BankAddress) obj;
        return number == that.number && postalCode == that.postalCode && streetName.equals(that.streetName)
                && cityName.equals(that.cityName) && countyName.equals(that.countyName) && countryName.equals(that.countryName);
    }

    /**
     * BankAddress 객체의 해시코드를 반환합니다.
     * @return int, BankAddress 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(streetName, number, cityName, countyName, postalCode, countryName);
    }
}