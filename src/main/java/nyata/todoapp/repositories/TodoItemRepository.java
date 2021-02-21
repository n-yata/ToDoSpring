package nyata.todoapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nyata.todoapp.entities.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
    public List<TodoItem> findByDoneOrderByTitleAsc(boolean done);
}
