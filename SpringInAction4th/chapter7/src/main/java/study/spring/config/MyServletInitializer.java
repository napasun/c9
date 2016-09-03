package study.spring.config;

import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
	
public class MyServletInitializer implements WebApplicationInitializer {
	//일일이 서블릿, 필터 등록
	
	//WebApplicationInitializer를 상속받아 구현한다.
	//onStartup 필수 구현
	public void onStartup(ServletContext arg0) throws ServletException {
		/*javax.servlet.Registration.Dynamic servlet = arg0.addServlet("name", "");
		servlet.addMapping("/");*/
		
		//필터 추가
		javax.servlet.FilterRegistration.Dynamic filter =  arg0.addFilter("filterName", CharacterEncodingFilter.class);
		//DispatcherType.
		filter.addMappingForUrlPatterns(null, false, "/");	
		
		
		/*DispatcherServlet dispatcherServlet = new DispatcherServlet();
		javax.servlet.ServletRegistration.Dynamic servlet = arg0.addServlet("appServlet", dispatcherServlet);
		servlet.addMapping("/");*/
		//servlet.setMultipartConfig(new MultipartConfigElement("/tmp/uploads"));
		
	}

}
