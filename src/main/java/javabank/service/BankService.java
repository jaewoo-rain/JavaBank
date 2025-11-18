package javabank.service;

import javabank.domain.Bank;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.BankValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

// Bank와 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
public class BankService {
    private final InMemoryRepository<Long, Bank> bankInMemoryRepository;
    private final ValidatorService<Bank> bankValidatorService = new BankValidatorService();

    /**
     * 새로운 BankService를 생성하는 생성자입니다.
     * @param bankInMemoryRepository InMemoryRepository<Long, Bank>, Bank 데이터를 처리하는 리포지토리
     */
    public BankService(InMemoryRepository<Long, Bank> bankInMemoryRepository) {
        this.bankInMemoryRepository = bankInMemoryRepository;
    }

    /**
     * 새로운 Bank를 추가합니다.
     * @param bankParam Bank, 추가할 은행
     * @return  null, Bank가 성공적으로 저장된 경우
     *          null이 아닌 Bank, 그렇지 않은 경우 (예: 동일한 ID의 Bank가 이미 존재)
     * @throws ValidationException, 추가하려는 Bank가 유효하지 않을 경우
     * @throws ParseException, 파싱 예외 발생 시
     */
    public Bank addBank(Bank bankParam) throws ValidationException, ParseException {
        Bank bank = bankInMemoryRepository.save(bankParam);
        bankValidatorService.validateAdd(bank);
        return bank;
    }

    /**
     * Bank를 삭제합니다.
     * @param bankIDParam, 삭제할 Bank의 ID
     * @return  null, 삭제하려는 Bank가 존재하지 않는 경우
     *          null이 아닌 Bank, 삭제된 Bank
     * @throws ValidationException, 삭제하려는 Bank가 존재하지 않을 경우
     */
    public Bank deleteBank(Long bankIDParam) throws ValidationException {
        Bank bank = bankInMemoryRepository.delete(bankIDParam);
        bankValidatorService.validateDelete(bank);
        return bank;
    }
}