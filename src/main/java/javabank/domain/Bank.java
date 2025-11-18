package javabank.domain;

import javabank.repository.memory.InMemoryRepository;

import java.util.Objects;

// 은행 정보를 담는 엔티티 클래스입니다.
public class Bank extends Entity<Long>{
    protected String bankName; // 은행 이름
    protected BankAddress headquartersAddress; // 본사 주소
    protected String hqTelephoneNumber; // 본사 전화번호
    protected String hqEmail; // 본사 이메일
    protected String website; // 은행 웹사이트
    private InMemoryRepository<Long, BankBranch> bankBranches; // 은행 지점 목록

    /**
     * 새로운 Bank 객체를 생성하는 기본 생성자입니다.
     */
    public Bank() {

    }

    /**
     * 새로운 Bank 객체를 생성하는 생성자입니다.
     * @param bankName String, 은행의 이름
     * @param headquartersAddress BankAddress, 본사의 주소
     * @param hqTelephoneNumber String, 본사의 전화번호
     * @param hqEmail String, 본사의 이메일 주소
     * @param website String, 은행의 웹사이트
     * @param bankBranches InMemoryRepository<Long, BankBranch>, 은행의 지점 목록
     */
    public Bank(String bankName, BankAddress headquartersAddress, String hqTelephoneNumber, String hqEmail, String website, InMemoryRepository<Long, BankBranch> bankBranches) {
        this.bankName = bankName;
        this.headquartersAddress = headquartersAddress;
        this.hqTelephoneNumber = hqTelephoneNumber;
        this.hqEmail = hqEmail;
        this.website = website;
        this.bankBranches = bankBranches;
    }

    /**
     * 은행의 이름을 반환합니다.
     * @return String, 은행의 이름
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 은행의 이름을 설정합니다.
     * @param bankName String, 새로 설정할 은행의 이름
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 본사의 주소를 반환합니다.
     * @return BankAddress, 본사의 주소
     */
    public BankAddress getHeadquartersAddress() {
        return headquartersAddress;
    }

    /**
     * 본사의 주소를 설정합니다.
     * @param headquartersAddress BankAddress, 새로 설정할 본사의 주소
     */
    public void setHeadquartersAddress(BankAddress headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    /**
     * 본사의 전화번호를 반환합니다.
     * @return String, 본사의 전화번호
     */
    public String getHqTelephoneNumber() {
        return hqTelephoneNumber;
    }

    /**
     * 본사의 전화번호를 설정합니다.
     * @param hqTelephoneNumber String, 새로 설정할 본사의 전화번호
     */
    public void setHqTelephoneNumber(String hqTelephoneNumber) {
        this.hqTelephoneNumber = hqTelephoneNumber;
    }

    /**
     * 본사의 이메일 주소를 반환합니다.
     * @return String, 본사의 이메일 주소
     */
    public String getHqEmail() {
        return hqEmail;
    }

    /**
     * 본사의 이메일 주소를 설정합니다.
     * @param hqEmail String, 새로 설정할 본사의 이메일 주소
     */
    public void setHqEmail(String hqEmail) {
        this.hqEmail = hqEmail;
    }

    /**
     * 은행의 웹사이트를 반환합니다.
     * @return String, 은행의 웹사이트
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 은행의 웹사이트를 설정합니다.
     * @param website String, 새로 설정할 은행의 웹사이트
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * 은행의 지점 목록을 반환합니다.
     * @return InMemoryRepository<Long, BankBranch>, 은행의 지점 레포지토리
     */
    public InMemoryRepository<Long, BankBranch> getBankBranches() {
        return bankBranches;
    }

    /**
     * 은행의 지점 목록을 설정합니다.
     * @param bankBranches InMemoryRepository<Long, BankBranch>, 새로 설정할 은행의 지점 레포지토리
     */
    public void setBankBranches(InMemoryRepository<Long, BankBranch> bankBranches) {
        this.bankBranches = bankBranches;
    }

    /**
     * Bank 객체의 문자열 표현을 반환합니다.
     * @return String, Bank 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "Bank{" +
                "ID='" + getId() + "'" +
                ", bankName='" + bankName + "'" +
                ", headquartersAddress=" + headquartersAddress +
                ", hqTelephoneNumber='" + hqTelephoneNumber + "'" +
                ", hqEmail='" + hqEmail + "'" +
                ", website='" + website + "'" +
                ", bankBranches=" + bankBranches +
                '}';
    }

    /**
     * 두 Bank 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 모든 필드가 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bank that = (Bank) obj;
        return bankName.equals(that.bankName) && headquartersAddress.equals(that.headquartersAddress)  && hqTelephoneNumber.equals(that.hqTelephoneNumber)
                && hqEmail.equals(that.hqEmail) && website.equals(that.website) && bankBranches.equals(that.bankBranches);
    }

    /**
     * Bank 객체의 해시코드를 반환합니다.
     * @return int, Bank 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(bankName, headquartersAddress, hqTelephoneNumber, hqEmail, website, bankBranches);
    }
}