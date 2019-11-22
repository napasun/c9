package study.spring_1_5th.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.spring_1_5th.repository.TodoRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @Test
    public void check_todo_count() {
        assertEquals(3, todoRepository.count());
    }
}
