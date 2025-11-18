package javabank.reader;

import java.io.IOException;

// System.in으로부터 ID(Long 타입)를 읽어오는 클래스입니다.
public class ReaderID implements Reader<Long>{

    /**
     * System.in으로부터 ID를 읽어옵니다.
     * @return Long, 읽어온 ID
     * @throws IOException, 입출력 예외 발생 시
     */
    @Override
    public Long read() throws IOException {
        long id;
        String idAsString;
        while(true) {
            System.out.println("ID를 입력하세요: ");
            idAsString = bufferedReader.readLine();
            try {
                id = Long.parseLong(idAsString);
                break;
            } catch (NumberFormatException e) {
                System.err.println("유효한 ID(숫자)를 입력해주세요.");
            }
        }
        return id;
    }
}