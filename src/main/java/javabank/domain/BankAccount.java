package javabank.domain;

import javabank.domain.banking.operations.Operation;
import javabank.repository.memory.InMemoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 은행 계좌 정보를 담는 엔티티 클래스입니다.
public class BankAccount extends Entity<Long>{
    private String ibanCode; // 국제 은행 계좌 번호 (IBAN)
    private double balance; // 계좌 잔액
    private InMemoryRepository<Long, Card> validCards; // 계좌에 연결된 유효한 카드 목록
    private List<Class<? extends Operation>> validOperations; // 계좌에서 허용되는 작업 유형 목록
    private InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations; // 계좌의 거래 내역

    /**
     * 새로운 BankAccount 객체를 생성하는 생성자입니다.
     * @param ibanCode String, 은행 계좌의 IBAN 코드
     * @param balance double, 은행 계좌의 잔액
     * @param validCards InMemoryRepository<Long, Card>, 계좌와 연결된 유효한 카드 목록
     * @param validOperations List<Class<? extends Operation>>, 계좌에서 허용되는 작업 목록
     * @param bankingOperations InMemoryRepository<Long, Tuple<Operation, Card>>, 고객이 수행한 은행 작업 내역
     */
    public BankAccount(String ibanCode, double balance, InMemoryRepository<Long, Card> validCards, List<Class<? extends Operation>> validOperations, InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations) {
        this.ibanCode = ibanCode;
        this.balance = balance;
        this.validCards = validCards;
        this.validOperations = validOperations;
        this.bankingOperations = bankingOperations;
    }

    /**
     * 은행 계좌의 IBAN 코드를 반환합니다.
     * @return String, 은행 계좌의 IBAN 코드
     */
    public String getIbanCode() {
        return ibanCode;
    }

    /**
     * 은행 계좌의 IBAN 코드를 설정합니다.
     * @param ibanCode String, 새로 설정할 은행 계좌의 IBAN 코드
     */
    public void setIbanCode(String ibanCode) {
        this.ibanCode = ibanCode;
    }

    /**
     * 은행 계좌의 잔액을 반환합니다.
     * @return double, 은행 계좌의 잔액
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 은행 계좌의 잔액을 설정합니다.
     * @param balance double, 새로 설정할 은행 계좌의 잔액
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 계좌와 연결된 유효한 카드 목록을 반환합니다.
     * @return InMemoryRepository<Long, Card>, 유효한 카드 레포지토리
     */
    public InMemoryRepository<Long, Card> getValidCards() {
        return validCards;
    }

    /**
     * 계좌와 연결된 유효한 카드 목록을 설정합니다.
     * @param validCards InMemoryRepository<Long, Card>, 새로 설정할 유효한 카드 레포지토리
     */
    public void setValidCards(InMemoryRepository<Long, Card> validCards) {
        this.validCards = validCards;
    }

    /**
     * 계좌에서 허용되는 작업 목록을 반환합니다.
     * @return List<Class<? extends Operation>>, 허용되는 작업 레포지토리
     */
    public List<Class<? extends Operation>> getValidOperations() {
        return validOperations;
    }

    /**
     * 계좌에서 허용되는 작업 목록을 설정합니다.
     * @param validOperations List<Class<? extends Operation>>, 새로 설정할 허용되는 작업 레포지토리
     */
    public void setValidOperations(List<Class<? extends Operation>> validOperations) {
        this.validOperations = validOperations;
    }

    /**
     * 고객이 수행한 은행 작업 내역을 반환합니다.
     * @return InMemoryRepository<Long, Tuple<Operation, Card>>, 은행 작업 내역 레포지토리
     */
    public InMemoryRepository<Long, Tuple<Operation, Card>> getBankingOperations() {
        return bankingOperations;
    }

    /**
     * 고객이 수행한 은행 작업 내역을 설정합니다.
     * @param bankingOperations InMemoryRepository<Long, Tuple<Operation, Card>>, 새로 설정할 은행 작업 내역 레포지토리
     */
    public void setBankingOperations(InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations) {
        this.bankingOperations = bankingOperations;
    }

    /**
     * BankAccount 객체의 문자열 표현을 반환합니다.
     * @return String, BankAccount 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "BankAccount{"
                + "ID='" + getId() + "'"
                + ", ibanCode='" + ibanCode + "'"
                + ", valance='" + balance + "'"
                + ", validCards=" + validCards
                + ", validOperations=" + validOperations
                + ", bankingOperations=" + bankingOperations
                + "}";
    }

    /**
     * 두 BankAccount 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 모든 필드가 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount that = (BankAccount) obj;
        return balance == that.balance && Objects.equals(ibanCode, that.ibanCode) && Objects.equals(validCards, that.validCards)
                && Objects.equals(validOperations, that.validOperations) && Objects.equals(bankingOperations, that.bankingOperations);
    }

    /**
     * BankAccount 객체의 해시코드를 반환합니다.
     * @return int, BankAccount 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(ibanCode, balance, validCards, validOperations, bankingOperations);
    }
}