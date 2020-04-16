package study.spring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ControllerAdvice 모든 컨트롤에서 예외를 처리한다.
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    /**
     * DuplicateSpittleException 예외에 대한 처리
     */
    @ExceptionHandler(AllDuplicateException.class)
    public String handleNotFound() {
        return "error/duplicate";
    }

}
