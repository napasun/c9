package study.spring_1_5th;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {//http://localhost:8080/v2/api-docs //http://localhost:8080/swagger-ui.html#/
    @Bean
    public Docket api() {   //Docket: 스웨거 스프링 MVC 프레임워크를 사용해 스웨거 문서 생성을 설정하는 빌더 클래스
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())    //문서에 모든 API와 경로를 포함한다.
                .paths(PathSelectors.any()).build();
    }
}

// hateoas + swagger + spring boot 2.2.0은 현재 호환되지 않는다
