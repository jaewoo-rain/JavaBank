package javabank.console;

import javabank.UI.UI;

import java.io.IOException;

// 애플리케이션의 메인 클래스입니다.
public class Main {
    /**
     * 애플리케이션의 진입점(entry point)입니다.
     * @param args 커맨드 라인 인자
     * @throws IOException 입출력 예외 발생 시
     */
    public static void main(String[] args) throws IOException {
        UI consoleApplication = new UI();
        consoleApplication.startApp();
    }
}