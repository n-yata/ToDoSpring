package nyata.domain.service;

import java.util.List;

import nyata.domain.model.TodoItem;

/**
 * Todoアイテムのフォーム
 * @author nyata
 */
public class TodoItemForm {
    /* 表示リスト（完了・未完）の切替フラグ */
    private boolean isDone;
    /* 表示するTodoリスト */
    private List<TodoItem> todoItems;

    // setter, getter
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