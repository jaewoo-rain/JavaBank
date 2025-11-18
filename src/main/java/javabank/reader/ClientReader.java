package javabank.reader;

import javabank.domain.BankAccount;
import javabank.domain.Client;
import javabank.domain.ClientCredentials;
import javabank.domain.validators.BankAccountValidator;
import javabank.repository.memory.InMemoryRepository;

import java.io.IOException;
import java.util.ArrayList;

// System.in으로부터 Client 정보를 읽어오는 클래스입니다.
public class ClientReader implements Reader<Client>{
    /**
     * System.in으로부터 Client 정보를 읽어옵니다.
     * @return Client, 읽어온 Client 객체
     * @throws IOException, 입출력 예외 발생 시
     */
    @Override
    public Client rea!d() throws IOException {
        System.out.println("고객 정보를 입력해주세요!");
        Long idClient = new ReaderID().read();

        String firstName;
        System.out.print("이름: ");
        firstName = bufferedReader.readLine();

        String lastName;
        System.out.print("성: ");
        lastName = bufferedReader.readLine();

        String CNP;
        System.out.print("주민등록번호(CNP): ");
        CNP = bufferedReader.readLine();

        String telephoneNumber;
        System.out.print("전화번호: ");
        telephoneNumber = bufferedReader.readLine();

        String email;
        System.out.print("이메일: ");
        email = bufferedReader.readLine();

        ClientCredentials credentials;
        ClientCredentialsReader clientCredentialsReader = new ClientCredentialsReader();
        credentials = clientCredentialsReader.read();

        InMemoryRepository<Long, BankAccount> bankAccounts = new InMemoryRepository<>(new BankAccountValidator());

        Client client = new Client(firstName, lastName, CNP, telephoneNumber, email, credentials, bankAccounts);
        client.setId(idClient);
        return client;
    }
}