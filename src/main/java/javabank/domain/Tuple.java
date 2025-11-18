package javabank.domain;

import java.util.Objects;

/**
 * 제네릭 타입의 엔티티 쌍(튜플)을 정의하는 클래스입니다.
 * @param <E1> 튜플의 첫 번째 엔티티 타입
 * @param <E2> 튜플의 두 번째 엔티티 타입
 */
public class Tuple<E1, E2> extends Entity<Long> {
    private E1 e1; // 튜플의 첫 번째 요소
    private E2 e2; // 튜플의 두 번째 요소

    /**
     * 새로운 튜플을 생성하는 생성자입니다.
     * @param e1 E1, 튜플의 첫 번째 엔티티
     * @param e2 E2, 튜플의 두 번째 엔티티
     */
    public Tuple(E1 e1, E2 e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    /**
     * 튜플의 첫 번째 엔티티를 반환합니다.
     * @return E1, 튜플의 첫 번째 엔티티
     */
    public E1 getLeftEntity() {
        return e1;
    }

    /**
     * 튜플의 첫 번째 엔티티를 설정합니다.
     * @param e1 E1, 새로 설정할 첫 번째 엔티티
     */
    public void setLeftEntity(E1 e1) {
        this.e1 = e1;
    }

    /**
     * 튜플의 두 번째 엔티티를 반환합니다.
     * @return E2, 튜플의 두 번째 엔티티
     */
    public E2 getRightEntity() {
        return e2;
    }

    /**
     * 튜플의 두 번째 엔티티를 설정합니다.
     * @param e2 E2, 새로 설정할 두 번째 엔티티
     */
    public void setRightEntity(E2 e2) {
        this.e2 = e2;
    }

    /**
     * 튜플의 문자열 표현을 반환합니다.
     * @return String, 튜플의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "Tuple{"
                + "ID='" + getId() + "'"
                + "e1=" + e1 + ", "
                + "e2=" + e2 + "}";
    }

    /**
     * 두 튜플 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true,   두 튜플의 첫 번째와 두 번째 엔티티가 각각 같을 경우
     *          false,  그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tuple<?, ?> that = (Tuple<?, ?>) obj;
        return e1.equals(that.e1) && e2.equals(that.e2);
    }

    /**
     * 튜플의 해시코드를 반환합니다.
     * @return int, 튜플의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(e1, e2);
    }
}