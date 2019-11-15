package study.spring_1_5th.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import study.spring_1_5th.bean.TodoNotFoundException;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {    // ResponseEntityExceptionHandler: 중앙 집중식 예외 처리 클래스인 ControllerAdvice를 위해 스프링 MVC가 제공하는 기본 클래스
    @ExceptionHandler(TodoNotFoundException.class) // 메서드가 특정 예외(TodoNotFoundException)를 처리하도록 정의한다.
    public final ResponseEntity<ExceptionResponse> todoNotFound(TodoNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), "Any details you would want to add");
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
