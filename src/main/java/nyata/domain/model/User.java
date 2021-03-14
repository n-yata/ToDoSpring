package nyata.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * ユーザー情報のエンティティ
 * @author nyata
 */
@Entity
@Proxy(lazy = false)
@Table(name = "usr")
public class User {
    /* ユーザーID */
    @Id
    private String userId;
    /* パスワード */
    private String password;
    /* ファーストネーム */
    private String firstName;
    /* ラストネーム */
    private String lastName;
    /* ユーザー権限 */
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    // setter, getter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}