package study.spring.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import study.spring.exception.AllDuplicateException;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value = "/error", method = GET)
    public String error(Model model) {
        throw new AllDuplicateException();
    }
}
