package javabank.domain;

import javabank.repository.memory.InMemoryRepository;

import java.util.ArrayList;
import java.util.Objects;

// 고객 정보를 담는 엔티티 클래스입니다.
public class Client extends Entity<Long> {
    private String firstName; // 고객의 이름
    private String lastName; // 고객의 성
    private String CNP; // 고객의 주민등록번호 (고유 식별 번호)
    private String telephoneNumber; // 고객의 전화번호
    private String email; // 고객의 이메일 주소
    private ClientCredentials credentials; // 고객의 로그인 정보
    private InMemoryRepository<Long, BankAccount> bankAccounts; // 고객의 은행 계좌 목록

    /**
     * 새로운 Client 객체를 생성하는 생성자입니다.
     * @param firstName String, 고객의 이름
     * @param lastName String, 고객의 성
     * @param CNP String, 고객의 주민등록번호
     * @param telephoneNumber String, 고객의 전화번호
     * @param email String, 고객의 이메일 주소
     * @param credentials ClientCredentials, 고객의 로그인 정보
     * @param bankAccounts InMemoryRepository<Long, BankAccount>, 고객의 은행 계좌 목록
     */
    public Client(String firstName, String lastName, String CNP, String telephoneNumber, String email, ClientCredentials credentials, InMemoryRepository<Long, BankAccount> bankAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.credentials = credentials;
        this.bankAccounts = bankAccounts;
    }

    /**
     * 고객의 이름을 반환합니다.
     * @return String, 고객의 이름
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 고객의 이름을 설정합니다.
     * @param firstName String, 새로 설정할 고객의 이름
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 고객의 성을 반환합니다.
     * @return String, 고객의 성
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 고객의 성을 설정합니다.
     * @param lastName String, 새로 설정할 고객의 성
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 고객의 주민등록번호를 반환합니다.
     * @return String, 고객의 주민등록번호
     */
    public String getCNP() {
        return CNP;
    }

    /**
     * 고객의 주민등록번호를 설정합니다.
     * @param CNP String, 새로 설정할 고객의 주민등록번호
     */
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    /**
     * 고객의 전화번호를 반환합니다.
     * @return String, 고객의 전화번호
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * 고객의 전화번호를 설정합니다.
     * @param telephoneNumber String, 새로 설정할 고객의 전화번호
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * 고객의 이메일 주소를 반환합니다.
     * @return String, 고객의 이메일 주소
     */
    public String getEmail() {
        return email;
    }

    /**
     * 고객의 이메일 주소를 설정합니다.
     * @param email String, 새로 설정할 고객의 이메일 주소
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 고객의 로그인 정보를 반환합니다.
     * @return ClientCredentials, 고객의 로그인 정보
     */
    public ClientCredentials getCredentials() {
        return credentials;
    }

    /**
     * 고객의 로그인 정보를 설정합니다.
     * @param credentials ClientCredentials, 새로 설정할 고객의 로그인 정보
     */
    public void setCredentials(ClientCredentials credentials) {
        this.credentials = credentials;
    }

    /**
     * 고객의 은행 계좌 목록을 반환합니다.
     * @return InMemoryRepository<Long, BankAccount>, 고객의 은행 계좌 레포지토리
     */
    public InMemoryRepository<Long, BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    /**
     * 고객의 은행 계좌 목록을 설정합니다.
     * @param bankAccounts InMemoryRepository<Long, BankAccount>, 새로 설정할 고객의 은행 계좌 레포지토리
     */
    public void setBankAccounts(InMemoryRepository<Long, BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    /**
     * Client 객체의 문자열 표현을 반환합니다.
     * @return String, Client 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "Client{"
                + "ID='" + getId() + "'" +
                ", firstName='" + firstName + "'" +
                ", lastName='" + lastName + "'" +
                ", CNP='" + CNP + "'" +
                ", telephoneNumber='" + telephoneNumber + "'" +
                ", email='" + email + "'" +
                ", credentials=" + credentials +
                ", bankAccounts=" + bankAccounts +
                '}';
    }

    /**
     * 두 Client 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 모든 필드가 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client that = (Client) obj;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && CNP.equals(that.CNP) && telephoneNumber.equals(that.telephoneNumber)
                && Objects.equals(email, that.email) && credentials.equals(that.credentials) && bankAccounts.equals(that.bankAccounts);
    }

    /**
     * Client 객체의 해시코드를 반환합니다.
     * @return int, Client 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, CNP, telephoneNumber, email, credentials, bankAccounts);
    }
}