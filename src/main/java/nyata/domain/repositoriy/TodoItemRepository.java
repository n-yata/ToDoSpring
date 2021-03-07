package nyata.domain.repositoriy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nyata.domain.model.TodoItem;

/**
 * Todoのレポジトリ
 * @author yata1
 *
 */
public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
    public List<TodoItem> findByDoneOrderByTitleAsc(boolean done);
    public long deleteByDone(boolean done);
}
