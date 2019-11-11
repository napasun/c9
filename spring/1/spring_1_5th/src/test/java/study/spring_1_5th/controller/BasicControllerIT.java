package study.spring_1_5th.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import study.spring_1_5th.Application;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerIT {
    private static final String LOCAL_HOST = "http://localhost:";

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void welcome() throws Exception {
        ResponseEntity<String> response = template.getForEntity(createURL("/welcome"), String.class);
        assertThat(response.getBody(), equalTo("Hello"));
    }

    private String createURL(String uri) {
        return LOCAL_HOST+port+uri;
    }

    @Test
    public void welcomeWithObject() throws Exception {
        ResponseEntity<String> response = template.getForEntity(createURL("/welcome-with-object"), String.class);
        assertThat(response.getBody(), containsString("Hello"));
    }

    @Test
    public void welcomeWithParameter() throws Exception {
        ResponseEntity<String> response = template.getForEntity(createURL("/welcome-with-parameter/name/Buddy"), String.class);
        assertThat(response.getBody(), containsString("Hello World, Buddy"));
    }
}
