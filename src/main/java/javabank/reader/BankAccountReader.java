package javabank.reader;

import javabank.domain.BankAccount;
import javabank.domain.Card;
import javabank.domain.Tuple;
import javabank.domain.banking.operations.Operation;
import javabank.domain.validators.BankAccountValidator;
import javabank.domain.validators.CardValidator;
import javabank.domain.validators.OperationValidator;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// System.in으로부터 BankAccount 정보를 읽어오는 클래스입니다.
public class BankAccountReader implements Reader<BankAccount> {

    /**
     * System.in으로부터 BankAccount 정보를 읽어옵니다.
     *
     * @return BankAccount, 읽어온 BankAccount 객체
     * @throws IOException, 입출력 예외 발생 시
     */
    @Override
    public BankAccount read() throws IOException {
        System.out.println("은행 계좌 정보를 입력해주세요!");
        Long idBankAccount = new ReaderID().read();

        String ibanCode;
        System.out.print("IBAN 코드: ");
        ibanCode = bufferedReader.readLine();

        double balance;
        System.out.println("잔액: ");
        balance = Double.parseDouble(bufferedReader.readLine());

        InMemoryRepository<Long, Card> validCards = new InMemoryRepository<>(new CardValidator());
        List<Class<? extends Operation>> validOperations = new ArrayList<Class<? extends Operation>>();

        InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations = new InMemoryRepository<>(BankAccountValidator::validateBankingOperation);

        BankAccount bankAccount = new BankAccount(ibanCode, balance, validCards, validOperations, bankingOperations);
        bankAccount.setId(idBankAccount);
        return bankAccount;
    }
}