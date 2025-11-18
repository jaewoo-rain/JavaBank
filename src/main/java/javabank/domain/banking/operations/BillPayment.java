package javabank.domain.banking.operations;

import java.util.Date;

// 청구서 지불(BillPayment) 작업을 나타내는 클래스입니다.(공과금)
// Operation 클래스를 상속받습니다.
public class BillPayment extends Operation {
    // BillPayment와 관련된 특정 필드 및 메서드가 여기에 추가될 수 있습니다.

    /**
     * BillPayment에 대한 기본 생성자입니다.
     * 부모 클래스인 Operation의 생성자를 호출합니다.
     */
    public BillPayment(Date operationDate, String operationDetails, boolean successfulOperation) {
        super(operationDate, operationDetails, successfulOperation);
    }
}