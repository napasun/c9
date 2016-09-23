package study.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .formLogin()
	        .loginPage("/loginPage")
	      .and()
	        .logout()
	          .logoutSuccessUrl("/")
	      .and()
	      .rememberMe()
	        .tokenRepository(new InMemoryTokenRepositoryImpl())
	        .tokenValiditySeconds(2419200)
	        .key("asdf")
	      .and()
	       .httpBasic()
	         .realmName("asdf")
	      .and()
	      .authorizeRequests()
	        .antMatchers("/fileupload/**").authenticated()
	        .anyRequest().permitAll()
	        .and()
	      .requiresChannel()
	      	.antMatchers("/").requiresSecure();
	  }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
	        .withUser("testuset").password("password").roles("USER", "CASH")
	        .and()
	        .withUser("testuset").password("password").roles("USER", "CASH");
	}
  

  
}
