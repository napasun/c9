package study.spring_1_5th.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeDataService {
    @Value("${somedataservice.url}") //프로퍼티에서 값 불러오기
    private String url;
    public String retrieveSomeData() {
        return "data from service";
    }
}
