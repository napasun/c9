package study.spring_1_5th.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// p222
@RunWith(SpringRunner.class)
@WebMvcTest(BasicController.class)
public class BasicControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void welcome() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON))        // Accept 헤더 값 application/json으로 /welcome을 요청한다.
                .andExpect(status().isOk())     // 응답 상태가 200인가?
                .andExpect(content().string(equalTo("Hello")));     // 응답 내용이 hello인가?
    }

    @Test
    public void welcomeWithObject() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/welcome-with-object")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello"))
        );
    }

    @Test
    public void welcomeWithParameter() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/welcome-with-parameter/name/Buddy")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World, Buddy"))
        );
    }
}
