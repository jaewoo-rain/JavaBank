package javabank.reader;

import javabank.domain.BankAddress;
import javabank.domain.BankBranch;
import javabank.domain.Client;
import javabank.domain.validators.ClientValidator;
import javabank.repository.memory.InMemoryRepository;

import java.io.IOException;
import java.util.ArrayList;

// System.in으로부터 BankBranch 정보를 읽어오는 클래스입니다.
public class BankBranchReader implements Reader<BankBranch> {
    /**
     * System.in으로부터 BankBranch 정보를 읽어옵니다.
     * @return BankBranch, 읽어온 BankBranch 객체
     * @throws IOException, 입출력 예외 발생 시
     */
    @Override
    public BankBranch read() throws IOException {
        System.out.println("은행 지점 정보를 입력해주세요!");
        Long idBankBranch = new ReaderID().read();

        String bicCode;
        System.out.print("BIC 코드: ");
        bicCode = bufferedReader.readLine();

        String swiftCode;
        System.out.print("SWIFT 코드: ");
        swiftCode = bufferedReader.readLine();

        BankAddress bankAddress;
        BankAddressReader bankAddressReader = new BankAddressReader();
        bankAddress = bankAddressReader.read();

        String bankTelephoneNumber;
        System.out.print("전화번호: ");
        bankTelephoneNumber = bufferedReader.readLine();

        String bankEmail;
        System.out.print("이메일 주소: ");
        bankEmail = bufferedReader.readLine();

        InMemoryRepository<Long, Client> clients = new InMemoryRepository<>(new ClientValidator());

        BankBranch bankBranch =  new BankBranch(bicCode, swiftCode, bankAddress, bankTelephoneNumber, bankEmail, clients);
        bankBranch.setId(idBankBranch);
        return bankBranch;
    }
}