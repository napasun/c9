package study.spring_1_5th.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import study.spring_1_5th.bean.Todo;
import study.spring_1_5th.bean.TodoNotFoundException;
import study.spring_1_5th.service.TodoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class TodoController {
    @Autowired private TodoService todoService;

    @ApiOperation( //p283
            value = "이름으로 모든 todos 검색",     //요약
            notes = "일치하는 todos 리스트가 반환, 페이징은 지원안함", //설명
            response = Todo.class,
            responseContainer = "List",
            produces = "application/json")
    @Cacheable(cacheNames = "todos", condition = "#user.length < 10")
    @GetMapping("/user/{name}/todos")
    public List<Todo> retrieveTodos(@PathVariable String name) {
        return todoService.retrieveTodos(name);
    }

    @GetMapping(path = "/users/{name}/todos/{id}")
    public Resource<Todo> retrieveTodo(@PathVariable String name, @PathVariable int id) {
        Todo todo = todoService.retrieveTodo(id);
        if (todo == null) {
            throw new TodoNotFoundException("Todo Not Found");
        }

        Resource<Todo> todoResource = new Resource<Todo>(todo);
        /**
         * {"id":1,"user":"Jack","desc":"Learn Spring MVC","targetDate":1573892007908,"done":false,"_links":{"parent":{"href":"http://localhost:8080/users/Jack/todos"}}}
         * */
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveTodos(name));		//현재 클래스에서 retrieveTodos 메서드에 대한 링크를 가져온다.
        todoResource.add(linkTo.withRel("parent"));		//현재 자원과의 관계는 parent 이다.
        return todoResource;
    }
//    @GetMapping(path = "/users/{name}/todos/{id}")
//    public EntityModel<Todo> retrieveTodo(@PathVariable String name, @PathVariable int id) {
//        Todo todo = todoService.retrieveTodo(id);
//        if (todo == null) {
//            throw new TodoNotFoundException("Todo Not Found");
//        }
//        //Resouces => EntityModel
//        EntityModel<Todo> todoResource = new EntityModel<Todo>(todo);
//        /**
//         * {"id":1,"user":"Jack","desc":"Learn Spring MVC","targetDate":1573892007908,"done":false,"_links":{"parent":{"href":"http://localhost:8080/users/Jack/todos"}}}
//         * */
//        // ControllerLinkBuilder는 server.mvc로 이동, 사용되지 않음 경고표시, WebMvcLinkBuilder로 대체됨.
//        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveTodos(name));		//현재 클래스에서 retrieveTodos 메서드에 대한 링크를 가져온다.
//        todoResource.add(linkTo.withRel("parent"));		//현재 자원과의 관계는 parent 이다.
//        return todoResource;
//    }

    @RequestMapping(method = RequestMethod.POST, path = "/users/{name}/todos")
    ResponseEntity<?> add(@PathVariable String name, @Valid @RequestBody Todo todo) {
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
