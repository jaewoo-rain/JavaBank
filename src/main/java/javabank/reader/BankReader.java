package javabank.reader;

import javabank.domain.Bank;
import javabank.domain.BankAddress;
import javabank.domain.BankBranch;
import javabank.domain.validators.BankBranchValidator;
import javabank.repository.memory.InMemoryRepository;

import java.io.IOException;

// System.in으로부터 Bank 정보를 읽어오는 클래스입니다.
public class BankReader implements Reader<Bank>{
    /**
     * System.in으로부터 Bank 정보를 읽어옵니다.
     * @return Bank, 읽어온 Bank 객체
     * @throws IOException, 입출력 예외 발생 시
     */
    @Override
    public Bank read() throws IOException {
        System.out.println("은행 정보를 입력해주세요!");
        Long idBank = new ReaderID().read();

        String bankName;
        System.out.print("은행 이름: ");
        bankName = bufferedReader.readLine();

        BankAddress headquartersAddress;
        BankAddressReader bankAddressReader = new BankAddressReader();
        headquartersAddress = bankAddressReader.read();

        String hqTelephoneNumber;
        System.out.print("전화번호: ");
        hqTelephoneNumber = bufferedReader.readLine();

        String hqEmail;
        System.out.print("이메일 주소: ");
        hqEmail = bufferedReader.readLine();

        String website;
        System.out.print("웹사이트: ");
        website = bufferedReader.readLine();

        InMemoryRepository<Long, BankBranch> bankBranches = new InMemoryRepository<>(new BankBranchValidator());

        Bank bank = new Bank(bankName, headquartersAddress, hqTelephoneNumber, hqEmail, website, bankBranches);
        bank.setId(idBank);
        return bank;
    }
}