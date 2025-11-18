package javabank.service;

import javabank.domain.BankAccount;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.BankAccountValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

// BankAccount와 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
public class BankAccountService {
    private final InMemoryRepository<Long, BankAccount> bankAccountInMemoryRepository;
    private final ValidatorService<BankAccount> bankAccountValidatorService = new BankAccountValidatorService();

    /**
     * 새로운 BankAccountService를 생성하는 생성자입니다.
     * @param bankAccountInMemoryRepository InMemoryRepository<Long, BankAccount>, BankAccount 데이터를 처리하는 리포지토리
     */
    public BankAccountService(InMemoryRepository<Long, BankAccount> bankAccountInMemoryRepository) {
        this.bankAccountInMemoryRepository = bankAccountInMemoryRepository;
    }

    /**
     * 새로운 BankAccount를 추가합니다.
     * @param bankAccountParam BankAccount, 추가할 은행 계좌
     * @return  null, BankAccount가 성공적으로 저장된 경우
     *          null이 아닌 BankAccount, 그렇지 않은 경우 (예: 동일한 ID의 BankAccount가 이미 존재)
     * @throws ValidationException, 추가하려는 BankAccount가 유효하지 않을 경우
     * @throws ParseException, 파싱 예외 발생 시
     */
    public BankAccount addBankAccount(BankAccount bankAccountParam) throws ValidationException, ParseException {
        BankAccount bankAccount = bankAccountInMemoryRepository.save(bankAccountParam);
        bankAccountValidatorService.validateAdd(bankAccount);
        return bankAccount;
    }

    /**
     * BankAccount를 삭제합니다.
     * @param bankAccountIDParam, 삭제할 BankAccount의 ID
     * @return  null, 삭제하려는 BankAccount가 존재하지 않는 경우
     *          null이 아닌 BankAccount, 삭제된 BankAccount
     * @throws ValidationException, 삭제하려는 BankAccount가 존재하지 않을 경우
     */
    public BankAccount deleteBankAccount(Long bankAccountIDParam) throws ValidationException {
        BankAccount bankAccount = bankAccountInMemoryRepository.delete(bankAccountIDParam);
        bankAccountValidatorService.validateDelete(bankAccount);
        return bankAccount;
    }
}