package study;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer() {	//기존 스프링 설정이 없을 경우 생성자로 필터 설정을 해주어야 한다.
		super(SecurityConfig.class);
	}
}
