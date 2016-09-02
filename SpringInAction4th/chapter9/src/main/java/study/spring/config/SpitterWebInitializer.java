package study.spring.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * customizeRegistration 메서드를 오버라이딩함으로써 DispatcherServlet에 추가적인 설정을 적용한다.
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// 파일 업로드 설정
		// 업로드 라이브러리는 WebConfig에서 빈으로 설정
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploads", 2097152, 4194304, 0));
	}

	
	
	
	@Override
	protected Filter[] getServletFilters() {
		//AbstractAnnotationConfigDispatcherServletInitializer에 있는 getServletFilters()를 오버라이딩해서 필터를 등록한다.
		return super.getServletFilters();
	}

}