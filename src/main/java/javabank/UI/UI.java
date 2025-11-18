package javabank.UI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 콘솔 기반 사용자 인터페이스(UI)를 관리하는 클래스입니다.
public class UI {
    // 메인 메뉴를 출력합니다.
    private void mainMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\tJavaBank");
        System.out.println("-------------------------------------------------");
        System.out.println("\n\n아래 메뉴에서 옵션을 선택해주세요: ");
        System.out.println("1. 로그인");
        System.out.println("2. 새 계정 만들기");
        System.out.println("3. 종료");
    }

    // 로그인 메뉴를 출력합니다.
    private void loginMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\t로그인");
        System.out.println("-------------------------------------------------");
        System.out.println("\n\n아래 메뉴에서 옵션을 선택해주세요: ");
        System.out.println("1. 고객으로 로그인");
        System.out.println("2. 관리자로 로그인");
        System.out.println("3. 메인 메뉴로 돌아가기");
        System.out.println("4. 종료");
    }

    // 계정 생성 메뉴를 출력합니다.
    private void createAccountMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\t계정 생성");
        System.out.println("-------------------------------------------------");
        System.out.println("\n\n아래 메뉴에서 옵션을 선택해주세요: ");
        System.out.println("1. 고객으로 가입");
        System.out.println("2. 메인 메뉴로 돌아가기");
        System.out.println("3. 종료");
    }

    /**
     * 애플리케이션을 시작하고 메인 메뉴를 표시합니다.
     * @throws IOException 입출력 예외 발생 시
     */
    public void startApp() throws IOException {
        int command;
        while(true) {
            try {
                mainMenu();
                System.out.print("선택: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                command = Integer.parseInt(bufferedReader.readLine());

                switch(command) {
                    case 1:
                        login();
                        return;
                    case 2:
                        createAccount();
                        return;
                    case 3:
                        return;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // 로그인 절차를 처리합니다.
    private void login() throws IOException {
        int command;
        while(true) {
            try {
                loginMenu();
                System.out.print("선택: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                command = Integer.parseInt(bufferedReader.readLine());

                switch(command) {
                    case 1:
                        // loginClient(); // 고객 로그인 로직 호출
                        return;
                    case 2:
                        // loginAdmin(); // 관리자 로그인 로직 호출
                        return;
                    case 3:
                        startApp();
                        return;
                    case 4:
                        return;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 계정 생성 절차를 처리합니다.
    private void createAccount() throws IOException {
        int command;
        while(true) {
            try {
                createAccountMenu();
                System.out.print("선택: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                command = Integer.parseInt(bufferedReader.readLine());

                switch(command) {
                    case 1:
                        // createAccountClient(); // 고객 계정 생성 로직 호출
                        return;
                    case 2:
                        startApp();
                        return;
                    case 3:
                        return;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}