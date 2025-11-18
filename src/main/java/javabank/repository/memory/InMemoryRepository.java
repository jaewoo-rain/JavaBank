package javabank.repository.memory;

import javabank.domain.Entity;
import javabank.domain.validators.Validator;
import javabank.repository.AbstractRepository;
import javabank.domain.validators.ValidationException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

// 메모리 내에서 CRUD 작업을 수행하는 리포지토리 클래스입니다.
public class InMemoryRepository<ID, E extends Entity<ID>> implements AbstractRepository<ID, E> {
    private final Validator<E> validator; // 엔티티 유효성 검사기
    protected Map<ID, E> entities; // 엔티티를 저장하는 맵

    /**
     * 새로운 InMemoryRepository를 생성하는 생성자입니다.
     * @param validator Validator<E>, InMemoryRepository의 유효성 검사기
     */
    public InMemoryRepository(Validator<E> validator) {
        this.validator = validator;
        entities = new HashMap<ID, E>();
    }

    /**
     * 리포지토리에서 특정 엔티티를 조회합니다.
     * @param id ID, 반환될 엔티티의 ID (null이 아니어야 함)
     * @return E, 지정된 ID를 가진 엔티티, 없으면 null
     * @throws IllegalArgumentException ID가 null일 경우
     */
    @Override
    public E findOne(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID는 null일 수 없습니다.");
        }
        return entities.get(id);
    }

    /**
     * 리포지토리의 모든 엔티티를 조회합니다.
     *
     * @return Iterable<E>, 모든 엔티티
     */
    @Override
    public Iterable<E> findAll() {
        return entities.values();
    }

    /**
     * 리포지토리에 새로운 엔티티를 추가합니다.
     * @param entity E, 추가될 엔티티 (null이 아니어야 함)
     * @return  null, 엔티티가 성공적으로 저장된 경우, 그렇지 않으면 해당 엔티티
     * @throws ValidationException, 엔티티가 유효하지 않을 경우
     * @throws IllegalArgumentException, 주어진 엔티티가 null일 경우
     */
    @Override
    public E save(E entity) throws ParseException {
        if (entity == null) {
            throw new IllegalArgumentException("엔티티는 null일 수 없습니다.");
        }
        validator.validate(entity);
        if (entities.get(entity.getId()) != null) {
            return entity;
        }
        else entities.put(entity.getId(), entity);
        return null;
    }

    /**
     * 지정된 ID의 엔티티를 리포지토리에서 삭제합니다.
     *
     * @param id ID, 삭제될 엔티티의 ID (null이 아니어야 함)
     * @return 삭제된 엔티티, 해당 ID의 엔티티가 없으면 null
     * @throws IllegalArgumentException, 주어진 ID가 null일 경우
     */
    @Override
    public E delete(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID는 null일 수 없습니다.");
        }
        return entities.remove(id);
    }

    /**
     * 리포지토리의 엔티티를 수정합니다.
     * @param entity E, 수정될 엔티티 (null이 아니어야 함)
     * @return null, 엔티티가 성공적으로 수정된 경우, 그렇지 않으면 해당 엔티티
     * @throws IllegalArgumentException, 주어진 엔티티가 null일 경우
     * @throws ValidationException, 엔티티가 유효하지 않을 경우
     */
    @Override
    public E update(E entity) throws ParseException {
        if (entity == null) {
            throw new IllegalArgumentException("엔티티는 null일 수 없습니다.");
        }
        validator.validate(entity);
        entities.put(entity.getId(), entity);

        if (entities.get(entity.getId()) != null) {
            entities.put(entity.getId(), entity);
            return null;
        }
        return entity;
    }
}