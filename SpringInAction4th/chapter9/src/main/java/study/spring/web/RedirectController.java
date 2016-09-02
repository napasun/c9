package study.spring.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import study.spring.model.TestData;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

  
  @RequestMapping(value="/re/{userNum}", method=GET)
  public String processRegistration(
     @PathVariable String userNum
     , @RequestParam("test") String test) {
    	
	  System.out.println(userNum);
	  System.out.println(test);
    return "home";
  }
  
  @RequestMapping(value="/re2", method=GET)
  public String processRegistration(
     TestData testData) {
    	
	  System.out.println(testData);
    return "home";
  }
  /**
   * 리다리렉션 URL 방식
   * */
  @RequestMapping(value="/url", method=GET)
  public String url() {
	  return "redirect:/redirect/re/1?test=url";
  }

  @RequestMapping(value="/model", method=GET)
  public String model(Model model) {
      model.addAttribute("test", "model");
      
      return "redirect:/redirect/re/2";
  }
  /**
   * 플래시 애트리뷰트 데이터를 세션으로 전달하고 요청이 끝난 후 소멸한다.
   * */
  @RequestMapping(value="/flash", method=GET)
  public String flash(RedirectAttributes model) {
      model.addFlashAttribute("test", new TestData());
      
      return "redirect:/redirect/re2";
  }
}
