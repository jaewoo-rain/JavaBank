package javabank.domain.banking.operations;

import javabank.domain.Entity;

import java.util.Date;
import java.util.Objects;

// 은행 거래(Operation)의 기본 정보를 담는 클래스입니다.
public class Operation extends Entity<Long> {
    private Date operationDate; // 거래 날짜 및 시간
    private String operationDetails; // 거래 상세 내역
    private boolean successfulOperation; // 거래 성공 여부

    /**
     * 새로운 Operation 객체를 생성하는 생성자입니다.
     * @param operationDate Date, 거래가 수행된 날짜 및 시간
     * @param operationDetails String, 거래의 상세 내역
     * @param successfulOperation boolean, 거래의 성공 여부를 나타내는 값
     */
    public Operation(Date operationDate, String operationDetails, boolean successfulOperation) {
        this.operationDate = operationDate;
        this.operationDetails = operationDetails;
        this.successfulOperation = successfulOperation;
    }

    /**
     * 거래가 수행된 날짜 및 시간을 반환합니다.
     * @return Date, 거래 날짜 및 시간
     */
    public Date getOperationDate() {
        return operationDate;
    }

    /**
     * 거래가 수행된 날짜 및 시간을 설정합니다.
     * @param operationDate Date, 새로 설정할 거래 날짜 및 시간
     */
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    /**
     * 거래의 상세 내역을 반환합니다.
     * @return String, 거래 상세 내역
     */
    public String getOperationDetails() {
        return operationDetails;
    }

    /**
     * 거래의 상세 내역을 설정합니다.
     * @param operationDetails String, 새로 설정할 거래 상세 내역
     */
    public void setOperationDetails(String operationDetails) {
        this.operationDetails = operationDetails;
    }

    /**
     * 거래의 성공 여부를 반환합니다.
     * @return boolean, 거래 성공 여부
     */
    public boolean isSuccessfulOperation() {
        return successfulOperation;
    }

    /**
     * 거래의 성공 여부를 설정합니다.
     * @param successfulOperation boolean, 새로 설정할 거래 성공 여부 값
     */
    public void setSuccessfulOperation(boolean successfulOperation) {
        this.successfulOperation = successfulOperation;
    }

    /**
     * Operation 객체의 문자열 표현을 반환합니다.
     * @return String, Operation 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "Operation{"
                + "ID=" + getId() + "'"
                + "operationDate=" + operationDate + 
                ", operationDetails='" + operationDetails + "'"
                + ", successfulOperation=" + successfulOperation + 
                '}';
    }

    /**
     * 두 Operation 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 모든 필드가 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Operation that = (Operation) obj;
        return successfulOperation == that.successfulOperation && operationDate.equals(that.operationDate) && operationDetails.equals(that.operationDetails);
    }

    /**
     * Operation 객체의 해시코드를 반환합니다.
     * @return int, Operation 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(operationDate, operationDetails, successfulOperation);
    }
}