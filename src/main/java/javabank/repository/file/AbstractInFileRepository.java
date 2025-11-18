package javabank.repository.file;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import javabank.domain.Entity;
import javabank.domain.validators.Validator;
import javabank.repository.memory.InMemoryRepository;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

// 파일 기반 리포지토리의 추상 클래스입니다. InMemoryRepository를 확장합니다.
public abstract class AbstractInFileRepository<ID, E extends Entity<ID>> extends InMemoryRepository<ID, E> {
    String fileName; // 데이터가 로드되거나 저장될 파일의 이름

    /**
     * 새로운 AbstractInFileRepository를 생성하는 생성자입니다.
     * @param fileName String, 데이터가 로드되거나 저장될 파일의 이름
     * @param validator Validator<E>, AbstractFileRepository의 유효성 검사기
     */
    public AbstractInFileRepository(String fileName, Validator<E> validator) {
        super(validator);
        this.fileName = fileName;
        loadData();
    }

    /**
     * 파일에서 데이터를 로드하는 메서드입니다.
     */
    private void loadData() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            // .csv 파일의 첫 번째 줄은 헤더이므로 건너뜁니다.
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> lines = csvReader.readAll();

            lines.forEach(line -> {
                E e = extractEntity(line);
                try {
                    super.save(e);
                }
                catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            });
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    /**
     * 파일에서 데이터를 다시 로드하는 메서드입니다. (파일을 비우고 현재 메모리의 모든 데이터를 다시 씁니다)
     */
    private void reload() {
        Iterable<E> currentEntities = super.findAll();
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.print("");
            writer.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("다시 로드할 파일이 존재하지 않습니다!");
        }
        currentEntities.forEach(this::writeToFile);
    }

    /**
     * 지정된 속성 목록을 사용하여 E 엔티티를 추출하는 추상 메서드입니다.
     * @param attributes String[], 추출할 엔티티의 속성
     * @return E, 주어진 속성을 기반으로 추출된 엔티티
     */
    public abstract E extractEntity(String[] attributes);

    /**
     * CSVReader를 위한 문자열 속성 목록을 생성하는 추상 메서드입니다.
     * @param entity Entity, 속성 목록을 결정할 엔티티
     * @return String[], 속성 목록
     */
    public abstract String[] createEntityAsStringList(E entity);

    /**
     * AbstractIInFileRepository에 새로운 엔티티를 추가합니다.
     * @param entity E, 추가될 엔티티 (null이 아니어야 함)
     * @return  null, 주어진 엔티티가 저장된 경우
     *          null이 아닌 엔티티, 그렇지 않은 경우 (예: 이미 존재)
     * @throws ParseException, 파싱 예외 발생 시
     */
    @Override
    public E save(E entity) throws ParseException {
        E e = super.save(entity);
        if (e == null) {
            writeToFile(entity);
        }
        return e;
    }

    /**
     * AbstractInFileRepository에서 엔티티를 삭제합니다.
     * @param id ID, 삭제될 엔티티의 ID (null이 아니어야 함)
     * @return E, 삭제된 엔티티 또는 엔티티가 존재하지 않으면 null
     */
    @Override
    public E delete(ID id) {
        E e = super.delete(id);
        if (e != null) {
          this.reload();
        }
        return e;
    }

    // TODO: update() 메서드 재정의 필요

    /**
     * 엔티티를 파일에 씁니다.
     * @param entity E, 파일에 쓸 엔티티
     */
    protected void writeToFile(E entity) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, true))) {
            csvWriter.writeNext(createEntityAsStringList(entity));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}