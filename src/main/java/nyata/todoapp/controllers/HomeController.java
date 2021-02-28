package nyata.todoapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nyata.todoapp.entities.TodoItem;
import nyata.todoapp.forms.TodoItemForm;
import nyata.todoapp.repositories.TodoItemRepository;

/**
 * Todo画面のコントローラー
 * @author yata1
 *
 */
@Controller
public class HomeController {
    @Autowired
    TodoItemRepository repository;

    @RequestMapping(value =  "/todo", method = RequestMethod.GET)
    public String todo(@ModelAttribute TodoItemForm todoItemForm, @RequestParam("isDone") Optional<Boolean> isDone) {
        todoItemForm.setDone(isDone.isPresent() ? isDone.get() : false);
        todoItemForm.setTodoItems(this.repository.findByDoneOrderByTitleAsc(todoItemForm.isDone()));
        return "/todo";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String done(@RequestParam("id") long id) {
        TodoItem item = this.repository.getOne(id);
        item.setDone(true);
        this.repository.save(item);
        return "redirect:/todo?isDone=false";
    }

    @RequestMapping(value = "/restore", method = RequestMethod.POST)
    public String RestoreAction(@RequestParam("id") long id) {
        TodoItem item = this.repository.getOne(id);
        item.setDone(false);
        this.repository.save(item);
        return "redirect:/todo?isDone=true";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String deleteItem(@RequestParam("id") long id) {
        this.repository.deleteById(id);
        return "redirect:/todo?isDone=true";
    }

    @RequestMapping(value="/deleteAll", method = RequestMethod.POST)
    @Transactional
    public String deleteAll(@RequestParam("done") boolean done) {
        this.repository.deleteByDone(done);
        return "redirect:/todo?isDone=true";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newItem(TodoItem item) {
        item.setDone(false);
        this.repository.save(item);
        return "redirect:/todo";
    }
}
