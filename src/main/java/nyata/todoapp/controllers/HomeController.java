package nyata.todoapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nyata.todoapp.entities.TodoItem;
import nyata.todoapp.forms.TodoItemForm;
import nyata.todoapp.repositories.TodoItemRepository;

@Controller
public class HomeController {
    @Autowired
    TodoItemRepository repository;

    @RequestMapping
    public String index(@ModelAttribute TodoItemForm todoItemForm, @RequestParam("isDone") Optional<Boolean> isDone) {
        todoItemForm.setDone(isDone.isPresent() ? isDone.get() : false);
        todoItemForm.setTodoItems(this.repository.findByDoneOrderByTitleAsc(todoItemForm.isDone()));
        return "index";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String done(@RequestParam("id") long id) {
        TodoItem item = this.repository.getOne(id);
        item.setDone(true);
        this.repository.save(item);
        return "redirect:/?isDone=false";
    }

    @RequestMapping(value = "/restore", method = RequestMethod.POST)
    public String RestoreAction(@RequestParam("id") long id) {
        TodoItem item = this.repository.getOne(id);
        item.setDone(false);
        this.repository.save(item);
        return "redirect:/?isDone=true";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String deleteItem(@RequestParam("id") long id) {
        this.repository.deleteById(id);
        return "redirect:/?isDone=true";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newItem(TodoItem item) {
        item.setDone(false);
        this.repository.save(item);
        return "redirect:/";
    }
}
