package nyata.todoapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todoitems")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "todoitems_id_seq")
    /* id */
    private Long id;
    /* タスク名 */
    private String title;
    /* 完了済判定フラグ */
    private Boolean done;

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
}
