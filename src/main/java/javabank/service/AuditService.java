package javabank.service;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

// 감사(Audit) 로그를 작성하는 서비스 클래스입니다. (싱글톤 패턴)
public class AuditService {
    private static AuditService auditService = null;

    private AuditService() {}

    /**
     * AuditService의 싱글톤 인스턴스를 반환합니다.
     * @return AuditService 인스턴스
     */
    public static AuditService getInstance() {
        if (auditService == null) {
            auditService = new AuditService();
        }
        return auditService;
    }

    /**
     * 감사 로그 파일에 작업 내역을 기록합니다.
     * @param action 기록할 작업 내용
     */
    public void write(String action) {
        try {
            File file = new File("src/main/resources/audit/audit.csv");

            // 감사 파일이 존재하지 않으면 생성합니다.
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true); // 이어쓰기 모드
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // 파일이 비어있으면 헤더를 추가합니다.
            if (file.length() == 0) {
                String[] header = {"Action", "Timestamp"};
                csvWriter.writeNext(header);
            }

            // csv에 데이터를 추가합니다.
            String[] data = {action, timestamp.toString()};
            csvWriter.writeNext(data);
            csvWriter.close();

        } catch (IOException e) {
            System.out.println("파일 처리 중 문제가 발생했습니다!");
            e.printStackTrace();
        }
    }

    /**
     * 감사 로그 파일에 특정 클라이언트의 작업 내역을 기록합니다.
     * @param action 기록할 작업 내용
     * @param clientID 작업을 수행한 클라이언트의 ID
     */
    public void write(String action, Long clientID) {
        try {
            File file = new File("src/main/resources/audit/audit.csv");

            // 감사 파일이 존재하지 않으면 생성합니다.
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true); // 이어쓰기 모드
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // 파일이 비어있으면 헤더를 추가합니다.
            if (file.length() == 0) {
                String[] header = {"Action", "Timestamp"};
                csvWriter.writeNext(header);
            }

            // csv에 데이터를 추가합니다.
            String actionParam = action + " - client@" + clientID.toString();
            String[] data = {actionParam, timestamp.toString()};
            csvWriter.writeNext(data);
            csvWriter.close();

        } catch (IOException e) {
            System.out.println("파일 처리 중 문제가 발생했습니다!");
            e.printStackTrace();
        }
    }
}