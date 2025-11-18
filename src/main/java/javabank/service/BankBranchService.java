package javabank.service;

import javabank.domain.BankBranch;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.BankBranchValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

// BankBranch와 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
public class BankBranchService {
    private final InMemoryRepository<Long, BankBranch> bankBranchInMemoryRepository;
    private final ValidatorService<BankBranch> bankBranchValidatorService = new BankBranchValidatorService();

    /**
     * 새로운 BankBranchService를 생성하는 생성자입니다.
     * @param bankBranchInMemoryRepository InMemoryRepository<Long, BankBranch>, BankBranch 데이터를 처리하는 리포지토리
     */
    public BankBranchService(InMemoryRepository<Long, BankBranch> bankBranchInMemoryRepository) {
        this.bankBranchInMemoryRepository = bankBranchInMemoryRepository;
    }

    /**
     * 새로운 BankBranch를 추가합니다.
     * @param bankBranchParam BankBranch, 추가할 은행 지점
     * @return  null, BankBranch가 성공적으로 저장된 경우
     *          null이 아닌 BankBranch, 그렇지 않은 경우 (예: 동일한 ID의 BankBranch가 이미 존재)
     * @throws ValidationException, 추가하려는 BankBranch가 유효하지 않을 경우
     * @throws ParseException, 파싱 예외 발생 시
     */
    public BankBranch addBankBranch(BankBranch bankBranchParam) throws ValidationException, ParseException {
        BankBranch bankBranch = bankBranchInMemoryRepository.save(bankBranchParam);
        bankBranchValidatorService.validateAdd(bankBranch);
        return bankBranch;
    }

    /**
     * BankBranch를 삭제합니다.
     * @param bankBranchIDParam, 삭제할 BankBranch의 ID
     * @return  null, 삭제하려는 BankBranch가 존재하지 않는 경우
     *          null이 아닌 BankBranch, 삭제된 BankBranch
     * @throws ValidationException, 삭제하려는 BankBranch가 존재하지 않을 경우
     */
    public BankBranch deleteBankBranch(Long bankBranchIDParam) throws ValidationException {
        BankBranch bankBranch = bankBranchInMemoryRepository.delete(bankBranchIDParam);
        bankBranchValidatorService.validateDelete(bankBranch);
        return bankBranch;
    }
}