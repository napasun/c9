package study.spring.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import study.spring.exception.DuplicateException;


@Controller
@RequestMapping("/exception")
public class ExceptionController {
	@RequestMapping(method = GET)
	  public String duplicateException(Model model) {
		throw new DuplicateException();
	  }
	
	
	/**
	 * 해당하는 클래스에서 발생하는 DuplicateException에러에 대한 처리를 한다.
	 * */
	@ExceptionHandler(DuplicateException.class)
	public String handleNotFound() {
		return "error/duplicate";
	}
}
