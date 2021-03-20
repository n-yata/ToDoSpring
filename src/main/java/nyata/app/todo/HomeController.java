package nyata.app.todo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nyata.domain.model.TodoItem;
import nyata.domain.repositoriy.TodoItemRepository;
import nyata.domain.service.TodoItemForm;
import nyata.domain.service.TodoUserDetails;

/**
 * Todo画面のコントローラ
 * @author nyata
 */
@Controller
public class HomeController {
    @Autowired
    TodoItemRepository repository;

    /**
     * 一覧表示
     * @param todoItemForm
     * @param isDone
     * @param userDetails
     * @param model
     */
    @GetMapping(value = "/todo")
    public String todo(@ModelAttribute TodoItemForm todoItemForm, @RequestParam("isDone") Optional<Boolean> isDone,
            @AuthenticationPrincipal TodoUserDetails userDetails, Model model) {
        todoItemForm.setDone(isDone.isPresent() ? isDone.get() : false);
        todoItemForm.setTodoItems(
                this.repository.findByDoneAndUserOrderByTododateAsc(todoItemForm.isDone(), userDetails.getUser()));
        model.addAttribute("firstName", userDetails.getUser().getFirstName());
        model.addAttribute("lastName", userDetails.getUser().getLastName());
        return "todo";
    }

    /**
     * 状態を「完了」に変更
     * @param id
     */
    @PostMapping(value = "/done")
    public String done(@RequestParam("id") long id) {
        TodoItem item = this.repository.getOne(id);
        item.setDone(true);
        this.repository.save(item);
        return "redirect:/todo?isDone=false";
    }

    /**
     * すべてのアイテムの状態を「完了」に変更
     * @param todoItemForm
     * @param userDetails
     */
    @PostMapping(value = "/doneAll")
    public String doneAll(@ModelAttribute TodoItemForm todoItemForm,
            @AuthenticationPrincipal TodoUserDetails userDetails) {
        todoItemForm.setTodoItems(this.repository.findByDoneAndUser(false, userDetails.getUser()));
        for (TodoItem todoitem : todoItemForm.getTodoItems()) {
            todoitem.setDone(true);
            this.repository.save(todoitem);
        }
        return "redirect:/todo?isDone=false";
    }

    /**
     * 状態を「未完」に変更
     * @param id
     */
    @PostMapping(value = "/restore")
    public String RestoreAction(@RequestParam("id") long id) {
        TodoItem item = this.repository.getOne(id);
        item.setDone(false);
        this.repository.save(item);
        return "redirect:/todo?isDone=true";
    }

    /**
     * アイテムを削除
     * @param id
     */
    @PostMapping(value = "/delete")
    public String deleteItem(@RequestParam("id") long id) {
        this.repository.deleteById(id);
        return "redirect:/todo?isDone=true";
    }

    /**
     * 「完了」状態のすべてのアイテムを削除
     * @param done
     * @param userDetails
     */
    @PostMapping(value = "/deleteAll")
    @Transactional
    public String deleteAll(@RequestParam("done") boolean done, @AuthenticationPrincipal TodoUserDetails userDetails) {
        this.repository.deleteByDoneAndUser(done, userDetails.getUser());
        return "redirect:/todo?isDone=true";
    }

    /**
     * 新規アイテムの登録
     * @param item
     * @param userDetails
     */
    @PostMapping(value = "/new")
    public String newItem(TodoItem item, @AuthenticationPrincipal TodoUserDetails userDetails) {
        item.setDone(false);
        item.setTododate(LocalDateTime.now());
        item.setUser(userDetails.getUser());
        this.repository.save(item);
        return "redirect:/todo";
    }
}