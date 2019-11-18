package study.spring_1_5th.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study.spring_1_5th.Application;
import study.spring_1_5th.bean.Todo;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerIT {
    @LocalServerPort private int port;

    private TestRestTemplate template = new TestRestTemplate();
    HttpHeaders headers = createHeaders("user-name", "user-password");  //Base64.getEncoder().encode 기본 인증 헤더를 생성한다.

    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }

    @Test
    public void retrieveTodos() throws Exception {
        String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" + ","
                + "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";

        ResponseEntity<String> response = template.exchange(createUrl("/users/Jack/todos")
                , HttpMethod.GET,
                new HttpEntity<String>(null, headers),  // 생성한 헤더를 RestTemplate에 저공하기 위해 HttpEntity를 사용한다.
                String.class);

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
//    @Test
//    public void retrieveTodos() throws Exception {
//        String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" + ","
//                + "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";
//
//        String uri = "/users/Jack/todos";
//
//        ResponseEntity<String> response = template.getForEntity(createUrl(uri), String.class);
//
//        JSONAssert.assertEquals(expected, response.getBody(), false);
//    }

    private String createUrl(String url) {
        return "http://localhost:"+port+url;
    }

    @Test
    public void retrieveTodo() throws Exception {
        String expected = "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}";

        ResponseEntity<String> response = template.getForEntity(createUrl("/users/Jack/todos/1"), String.class);
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
}
