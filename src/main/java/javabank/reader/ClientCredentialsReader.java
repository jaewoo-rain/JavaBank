package javabank.reader;

import javabank.domain.ClientCredentials;
import javabank.utils.security.PasswordEncryption;

import java.io.IOException;


// System.in으로부터 ClientCredentials 정보를 읽어오는 클래스입니다.
public class ClientCredentialsReader implements Reader<ClientCredentials> {
    /**
     * System.in으로부터 ClientCredentials 정보를 읽어옵니다.
     * @return ClientCredentials, 읽어온 ClientCredentials 객체
     * @throws IOException, 입출력 예외 발생 시
     */
    @Override
    public ClientCredentials read() throws IOException {
        System.out.println("고객 로그인 정보를 입력해주세요!");
        Long idClientCredentials = new ReaderID().read();

        String username;
        System.out.print("사용자 이름: ");
        username = bufferedReader.readLine();

        String password;
        System.out.print("비밀번호: ");
        password = bufferedReader.readLine();

        String salt = PasswordEncryption.getSalt(30);

        ClientCredentials clientCredentials = new ClientCredentials(username, password, salt);
        clientCredentials.setId(idClientCredentials);
        return clientCredentials;
    }
}