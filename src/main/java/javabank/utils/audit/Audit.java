package javabank.utils.audit;

// 감사(Audit) 로그에 기록될 작업 유형을 정의하는 열거형입니다.
public enum Audit {
    // 애플리케이션 시작 및 종료
    START_APP,
    STOP_APP,

    // 로그인 & 회원가입
    LOGIN_ADMIN,
    LOGIN_CLIENT,
    SIGNUP_CLIENT,

    // 관리자 권한
    ADD_BANK, DELETE_BANK, EDIT_BANK, // 은행
    ADD_BANKBRANCH, DELETE_BANKBRANCH, EDIT_BANKBRANCH, // 은행 지점
    ADD_BANKADDRESS, DELETE_BANKADDRESS, EDIT_BANKADDRESS, // 은행 주소
    DELETE_CLIENT_ADMIN, // 고객 (관리자)
    DELETE_BANKACCOUNT_ADMIN, // 은행 계좌 (관리자)

    // 고객 권한
    DELETE_CLIENT_CLIENT, // 고객 (고객)
    ADD_BANKACCOUNT, DELETE_BANKACCOUNT_CLIENT, EDIT_BANKACCOUNT, // 은행 계좌
    ADD_CARD, DELETE_CARD, // 카드
    ADD_OPERATION, DELETE_OPERATION, // 거래
    ADD_BANKING_OPERATION, EDIT_BANKING_OPERATION, DELETE_BANKING_OPERATION // 은행 거래
}