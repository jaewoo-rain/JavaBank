package javabank.domain;

import java.io.Serializable;

// 모든 엔티티의 기반이 되는 클래스입니다.
// ID 타입을 제네릭으로 사용합니다.
public class Entity<ID> implements Serializable {
    private static final long serialVersionUID = 3016605240731555842L;
    private ID id; // 엔티티의 고유 식별자

    /**
     * 엔티티의 ID를 반환합니다.
     * @return ID, 엔티티의 ID
     */
    public ID getId() {
        return id;
    }

    /**
     * 엔티티의 ID를 설정합니다.
     * @param id ID, 새로 설정할 엔티티의 ID
     */
    public void setId(ID id) {
        this.id = id;
    }
}