package study.spring_1_5th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import study.spring_1_5th.bean.Todo;
import study.spring_1_5th.bean.TodoNotFoundException;
import study.spring_1_5th.service.TodoService;

import java.net.URI;
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
        Todo todo = todoService.retrieveTodo(id);
        if(todo == null) {
            throw new TodoNotFoundException("Todo Not Found");
        }
        return todo;
    }

    @PostMapping("/users/{name}/todos")
    ResponseEntity<?> add(@PathVariable String name, @RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), todo.isDone());
        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping(path = "/users/dummy-service")
    public Todo errorService() {
        throw new RuntimeException("some Exception Occured");
    }
}
