package javabank.domain;

import java.util.Objects;

// 고객의 로그인 정보를 담는 엔티티 클래스입니다.
public class ClientCredentials extends Entity<Long>{
    private String username; // 사용자 이름
    private String password; // 암호화된 비밀번호
    private String salt;     // 비밀번호 암호화에 사용된 솔트 값

    /**
     * 새로운 ClientCredentials 객체를 생성하는 생성자입니다.
     * @param username String, 고객의 사용자 이름
     * @param password String, 고객의 비밀번호
     * @param salt String, 비밀번호 암호화에 사용된 솔트 값
     */
    public ClientCredentials(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    /**
     * 고객의 사용자 이름을 반환합니다.
     * @return String, 고객의 사용자 이름
     */
    public String getUsername() {
        return username;
    }

    /**
     * 고객의 사용자 이름을 설정합니다.
     * @param username String, 새로 설정할 고객의 사용자 이름
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 고객의 비밀번호를 반환합니다.
     * @return String, 고객의 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * 고객의 비밀번호를 설정합니다.
     * @param password String, 새로 설정할 고객의 비밀번호
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 비밀번호 암호화에 사용된 솔트 값을 반환합니다.
     * @return String, 솔트 값
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 비밀번호 암호화에 사용된 솔트 값을 설정합니다.
     * @param salt String, 새로 설정할 솔트 값
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * ClientCredentials 객체의 문자열 표현을 반환합니다.
     * @return String, ClientCredentials 객체의 직렬화된 문자열
     */
    @Override
    public String toString() {
        return "ClientCredentials{" +
                "ID='" + getId() + "'" +
                ", username='" + username + "'" +
                ", password='" + password + "'" +
                ", salt='" + salt + "'" +
                '}';
    }

    /**
     * 두 ClientCredentials 객체가 동일한지 확인합니다.
     * @param obj Object, 비교할 객체
     * @return  true, 사용자 이름, 비밀번호, 솔트 값이 모두 동일할 경우
     *          false, 그렇지 않을 경우
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClientCredentials that = (ClientCredentials) obj;
        return username.equals(that.username) && password.equals(that.password) && salt.equals(that.salt);
    }

    /**
     * ClientCredentials 객체의 해시코드를 반환합니다.
     * @return int, ClientCredentials 객체의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password, salt);
    }
}