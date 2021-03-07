package nyata.domain.form;

import java.util.List;

import nyata.domain.model.TodoItem;

/**
 * Todoのフォーム
 * @author yata1
 *
 */
public class TodoItemForm {
    private boolean isDone;
    private List<TodoItem> todoItems;

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