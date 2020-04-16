package study.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResponseStatus 이 났을 경우 HTTP 상태코드를 매핑한다.
 */
//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DuplicateException extends RuntimeException {

}
