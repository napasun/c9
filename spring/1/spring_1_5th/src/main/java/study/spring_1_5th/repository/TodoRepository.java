package study.spring_1_5th.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import study.spring_1_5th.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findAll();
    long count();
}
