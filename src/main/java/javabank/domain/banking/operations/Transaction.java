package javabank.domain.banking.operations;

// Transaction(거래) 작업을 나타내는 클래스입니다.
// Operation 클래스를 상속받습니다.
public class Transaction extends Operation {
    // Transaction과 관련된 특정 필드 및 메서드가 여기에 추가될 수 있습니다.

    /**
     * Transaction에 대한 기본 생성자입니다.
     * 부모 클래스인 Operation의 생성자를 호출합니다.
     */
    public Transaction(java.util.Date operationDate, String operationDetails, boolean successfulOperation) {
        super(operationDate, operationDetails, successfulOperation);
    }
}