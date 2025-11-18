package javabank.domain.banking.operations;

import java.util.Date;

// 캐시백(Cashback) 작업을 나타내는 클래스입니다.
// Operation 클래스를 상속받습니다.
public class Cashback extends Operation {
    // Cashback와 관련된 특정 필드 및 메서드가 여기에 추가될 수 있습니다.

    /**
     * Cashback에 대한 기본 생성자입니다.
     * 부모 클래스인 Operation의 생성자를 호출합니다.
     */
    public Cashback(Date operationDate, String operationDetails, boolean successfulOperation) {
        super(operationDate, operationDetails, successfulOperation);
    }
}