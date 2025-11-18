package javabank.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

// System.in으로부터 엔티티를 읽어오는 기능을 정의하는 인터페이스입니다.
public interface Reader<E> {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * System.in으로부터 엔티티를 읽어오는 추상 메서드입니다.
     * @return E, 읽어온 엔티티
     * @throws IOException, 입출력 예외 발생 시
     * @throws ParseException, 파싱 예외 발생 시
     */
    E read() throws IOException, ParseException;
}