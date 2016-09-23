# CHAPTER9 웹 애플리케이션 보안

#. 등록
 * DelegatingFilterProxy 필터를 등록해야 한다.
  1. WebSecurityConfigurerAdapter를 상속받는 설정클래스를 만든 다.
  1. XML
  ```xml
  <filter>
	<filter-name>springSecurityFilterChain</filter-name>
	<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
  </filter>
  <filter-mapping>
	<filter-name>springSecurityFilterChain</filter-name>
	<url-pattern>/*</url-pattern>
  </filter-mapping>
  ```
# 설정
 * WebSecurityConfigurerAdapter의 세가지 configure() 메소드를 오버라이딩하여 웹 보안을 설정한다.
  1. configure(WebSecurity) - 필터 연결 설정
  1. configure(HttpSecurity) - 인터셉터로 요청을 안전하게 보호하는 방법을 설정
  1. configure(AuthenticationManagerBuilder) - 사용자 세부 서비스를 설정
  
### 사용자 저장소 설정
 1. 인메모리
  * configure(AuthenticationManagerBuilder) 오버라이딩
  * AuthenticationManagerBuilder.inMemoryAuthentication() - 인메모리 활성화
  * withUser(String) - 유저이름 설정
  * password(String) - 암호 설정
  * roles(String) - 권한 설정
  * and() - 설정 연결
 1. 데이터 베이스
  * jdbcAuthentication() - jdbc 활성화
  * dataSource(DataSource) - DataSource 연결
  
### 인증이 필요한 요청 설정
 * configure(HttpSecurity) 오버라이딩
 * HttpSecurity.authorizeRequests() 호출, 반환되는 객체로 호출되는 메소드로 요청 보안 설정
 * 보안이 필요한 요청 명시 -> 해당 요청에 대한 권한 설정
 * 요청 명시
  1. antMatchers(String url) - 해당 URL
  1. regexMatchers(String reg) - 정규 표현식
  1. anyRequest() - 전부
 * 권한 설정
  1. authenticated() - 로그인한 사용자
  1. hasRole(String) - 권한 명시
  1. access(String) - 스프링 표현식으로 권한 명시 가능 access("hasRole('USER')")  320쪽 목록
  1. permitAll() - 보안 설정 없음
  1. 318쪽
 * 채널 보안
  1. requiresChannel() 호출
  1. HTTP requiresInsecure()
  1. HTTPS requiresSecure()
 * 사이트 간 요청 위조 방지
  1. CSRF 토큰 사용
  1. GET, HEAD, OPRION, TRACE 아닌 요청들을 가로 채서 CSRF 토큰을 확인함
  1. name = ${_csrf.parameterName}, value = ${_csrf.token}

### 로그인 화면
 * configure(HttpSecurity) 오버라이딩
 * formLogin() - 기본 로그인 페이지 활성화, /login 기본
 * loginPage(String url) - 사용자 정의 로그인 페이지 설정
 * httpBasic() - HTTP 기본 인증 활성화
 * 기억하기
  1. rememberMe() - 기억하기 활성화
  1. tokenValiditySecounds(int time) - 토큰을 저장하고 있는 시간 설정
  1. key(String key) - 토큰이 함호화 저장되는 데 사용되는 키
  1. form 데이터에서 name이 'remember-me' 인 데이터를 포함해야 한다.
 * 로그 아웃
  * /logout 기본설정
  * logout() - 로그아웃 설정 활성화
  * logoutSuccessUrl(String url) - 로그 아웃 시 리다이렉션 되는 페이지
  
### 뷰
 * spring-security-taglibs
 * %@ taglib prefix="security" uri="http://www.springframework.org/security/tags" % 태그 라이브러리 선언
 * security : authentiation property="" 프로퍼티 접근 331쪽 목록
 * security : authorize access="hasRole=('ROLE_USER')"
 