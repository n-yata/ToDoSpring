package nyata.domain.repositoriy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nyata.domain.model.TodoItem;
import nyata.domain.model.User;

/**
 * Todoアイテムのリポジトリ
 * @author nyata
 */
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    public List<TodoItem> findByDoneAndUser(boolean done, User user);

    public List<TodoItem> findByDoneAndUserOrderByTododateAsc(boolean done, User user);

    public long deleteByDoneAndUser(boolean done, User user);
}