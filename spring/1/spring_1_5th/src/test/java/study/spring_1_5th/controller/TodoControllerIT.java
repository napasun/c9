package study.spring_1_5th.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study.spring_1_5th.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerIT {
    @LocalServerPort private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void retrieveTodos() throws Exception {
        String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" + ","
                + "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";

        String uri = "/users/Jack/todos";

        ResponseEntity<String> response = template.getForEntity(createUrl(uri), String.class);

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createUrl(String url) {
        return "http://localhost:"+port+url;
    }
}
