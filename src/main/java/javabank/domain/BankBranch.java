package javabank.domain;

import javabank.repository.memory.InMemoryRepository;

import java.util.ArrayList;
import java.util.Objects;

// 은행 지점 정보를 담는 엔티티 클래스입니다.
public class BankBranch extends Entity<Long>{
    private String bicCode; // 은행 식별 코드 (BIC)
    private String swiftCode; // 국제 은행간 금융 통신 협회 코드 (SWIFT)
    private BankAddress bankAddress; // 지점 주소
    private String bankTelephoneNumber; // 지점 전화번호
    private String bankEmail; // 지점 이메일
    private InMemoryRepository<Long, Client> clients; // 지점의 고객 목록

    /**
     * 새로운 BankBranch 객체를 생성하는 생성자입니다.
     * @param bicCode String, 은행 지점의 BIC 코드
     * @param swiftCode String, 은행 지점의 SWIFT 코드
     * @param bankAddress BankAddress, 은행 지점의 주소
     * @param bankTelephoneNumber String, 은행 지점의 전화번호
     * @param bankEmail String, 은행 지점의 이메일 주소
     * @param clients InMemoryRepository<Long, Client>, 은행의 고객 레포지토리
     */
    public BankBranch(String bicCode, String swiftCode, BankAddress bankAddress, String bankTelephoneNumber, String bankEmail, InMemoryRepository<Long, Client> clients) {
        this.bicCode = bicCode;
        this.swiftCode = swiftCode;
        this.bankAddress = bankAddress;
        this.bankTelephoneNumber = bankTelephoneNumber;
        this.bankEmail = bankEmail;
        this.clients = clients;
    }

    /**
     * 은행 지점의 BIC 코드를 반환합니다.
     * @return String, 은행 지점의 BIC 코드
     */
    public String getBicCode() {
        return bicCode;
    }

    /**
     * 은행 지점의 BIC 코드를 설정합니다.
     * @param bicCode String, 새로 설정할 은행 지점의 BIC 코드
     */
    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    /**
     * 은행 지점의 SWIFT 코드를 반환합니다.
     * @return String, 은행 지점의 SWIFT 코드
     */
    public String getSwiftCode() {
        return swiftCode;
    }

    /**
     * 은행 지점의 SWIFT 코드를 설정합니다.
     * @param swiftCode String, 새로 설정할 은행 지점의 SWIFT 코드
     */
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    /**
     *  은행 지점의 주소를 반환합니다.
     * @return  BankAddress, 은행 지점의 주소
     */
    public BankAddress getBankAddress() {
        return bankAddress;
    }

    /**
     * 은행 지점의 주소를 설정합니다.
     * @param bankAddress BankAddress, 새로 설정할 은행 지점의 주소
     */
    public void setBankAddress(BankAddress bankAddress) {
        this.bankAddress = bankAddress;
    }

    /**
     * 은행 지점의 전화번호를 반환합니다.
     * @return String, 은행 지점의 전화번호
     */
    public String getBankTelephoneNumber() {
        return bankTelephoneNumber;
    }

    /**
     * 은행 지점의 전화번호를 설정합니다.
     * @param bankTelephoneNumber String, 새로 설정할 은행 지점의 전화번호
     */
    public void setBankTelephoneNumber(String bankTelephoneNumber) {
        this.bankTelephoneNumber = bankTelephoneNumber;
    }

    /**
     * 은행 지점의 이메일 주소를 반환합니다.
     * @return String, 은행 지점의 이메일 주소
     */
    public String getBankEmail() {
        return bankEmail;
    }

    /**
     * 은행 지점의 이메일 주소를 설정합니다.
     * @param bankEmail String, 새로 설정할 은행 지점의 이메일 주소
     */
    public void setBankEmail(String bankEmail) {
        this.bankEmail = bankEmail;
    }

    /**
     * 은행의 고객 목록을 반환합니다.
     * @return InMemoryRepository<Long, Client>, 은행의 고객 레포지토리
     */
    public InMemoryRepository<Long, Client> getClients() {
        return clients;
    }

    /**
     * 은행의 고객 목록을 설정합니다.
     * @param clients InMemoryRepository<Long, Client>, 새로 설정할 은행의 고객 레포지토리
     */
    public void setClients(InMemoryRepository<Long, Client> clients) {
        this.clients = clients;
    }

    /**
     * BankBranch 객체의 문자열 표현을 반환합니다.
     * @return String, BankBranch 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "BankBranch{"
                + "ID='" + getId() + "'" +
                ", bicCode='" + bicCode + "'" +
                ", swiftCode='" + swiftCode + "'" +
                ", bankAddress=" + bankAddress +
                ", bankTelephoneNumber='" + bankTelephoneNumber + "'" +
                ", bankEmail='" + bankEmail + "'" +
                ", clients=" + clients +
                '}';
    }

    /**
     * 두 BankBranch 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 모든 필드가 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankBranch that = (BankBranch) obj;
        return bicCode.equals(that.bicCode) && swiftCode.equals(that.swiftCode) && bankAddress.equals(that.bankAddress) && bankTelephoneNumber.equals(that.bankTelephoneNumber)
                && bankEmail.equals(that.bankEmail) && Objects.equals(clients, that.clients);
    }

    /**
     * BankBranch 객체의 해시코드를 반환합니다.
     * @return int, BankBranch 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(bicCode, swiftCode, bankAddress, bankTelephoneNumber, bankEmail, clients);
    }
}