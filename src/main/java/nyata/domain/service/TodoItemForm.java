package nyata.domain.service;

import java.util.List;

import nyata.domain.model.TodoItem;
import nyata.domain.model.User;

/**
 * Todoのフォーム
 * @author yata1
 *
 */
public class TodoItemForm {
    private User user;
    private boolean isDone;
    private List<TodoItem> todoItems;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public boolean isDone() {
        return isDone;
    }
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
    public List<TodoItem> getTodoItems() {
        return todoItems;
    }
    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}