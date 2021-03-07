package nyata.domain.repositoriy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nyata.domain.model.TodoItem;
import nyata.domain.model.User;

/**
 * Todoのレポジトリ
 * @author yata1
 *
 */
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    public List<TodoItem> findByDoneAndUserOrderByTitleAsc(boolean done, User user);
    public List<TodoItem> findByDoneOrderByTitleAsc(boolean done);
    public List<TodoItem> findByDoneOrderByTododateAsc(boolean done);
    public long deleteByDone(boolean done);
    public long deleteByDoneAndUser(boolean done, User user);
}
