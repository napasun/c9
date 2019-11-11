package study.spring_1_5th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.spring_1_5th.bean.Todo;
import study.spring_1_5th.service.TodoService;

import java.util.List;

@RestController
public class TodoController {
    @Autowired private TodoService todoService;

    @GetMapping("/user/{name}/todos")
    public List<Todo> retrieveTodos(@PathVariable String name) {
        return todoService.retrieveTodos(name);
    }

    @GetMapping(path = "/users/{name}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String name, @PathVariable int id) {
        return todoService.retrieveTodo(id);
    }
}
