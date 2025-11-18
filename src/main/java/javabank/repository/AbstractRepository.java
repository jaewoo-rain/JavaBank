package javabank.repository;

import javabank.domain.Entity;
import java.text.ParseException;

/**
 * CRUD 작업을 위한 추상 리포지토리(인터페이스)입니다.
 * @param <ID> - 엔티티 E는 ID 타입의 속성을 가져야 합니다.
 * @param <E> - 리포지토리에 저장될 엔티티의 타입
 */
public interface AbstractRepository<ID, E extends Entity<ID>> {

    /**
     * 리포지토리에서 특정 엔티티를 조회합니다.
     * @param id ID, 반환될 엔티티의 ID (null이 아니어야 함)
     * @return  지정된 ID를 가진 엔티티,
     *          해당 ID의 엔티티가 없으면 null
     */
    E findOne(ID id);

    /**
     * 리포지토리의 모든 엔티티를 조회합니다.
     * @return Iterable<E>, 모든 엔티티
     */
    Iterable<E> findAll();

    /**
     * 리포지토리에 새로운 엔티티를 추가합니다.
     * @param entity E, 추가될 엔티티 (null이 아니어야 함)
     * @return  null, 엔티티가 성공적으로 저장된 경우
     *          그렇지 않으면 해당 엔티티
     * @throws ParseException 파싱 오류 발생 시
     */
    E save(E entity) throws ParseException;

    /**
     * 지정된 ID의 엔티티를 리포지토리에서 삭제합니다.
     * @param id ID, 삭제될 엔티티의 ID (null이 아니어야 함)
     * @return 삭제된 엔티티, 해당 ID의 엔티티가 없으면 null
     */
    E delete(ID id);

    /**
     * 리포지토리의 엔티티를 수정합니다.
     * @param entity E, 수정될 엔티티 (null이 아니어야 함)
     * @return  null, 엔티티가 성공적으로 수정된 경우
     *          그렇지 않으면 해당 엔티티
     * @throws ParseException 파싱 오류 발생 시
     */
    E update(E entity) throws ParseException;
}