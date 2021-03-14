package nyata.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Todoアイテムのエンティティ
 * @author nyata
 *
 */
@Entity
@Table(name = "todoitems")
public class TodoItem {
    /* id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "todoitems_id_seq")
    private Long id;
    /* タスク名 */
    private String title;
    /* 完了判定フラグ */
    private Boolean done;
    /* 日付 */
    private LocalDateTime tododate;
    /* ユーザー情報 */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // setter, getter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDateTime getTododate() {
        return tododate;
    }

    public void setTododate(LocalDateTime tododate) {
        this.tododate = tododate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
