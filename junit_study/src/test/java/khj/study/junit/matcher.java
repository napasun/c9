package khj.study.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

/**
 * 매처
 * 햄크레스트 매처
 * 사용자 정의 비교 함수
 * */
public class matcher {
	@Test
	public void matchTest() {
		//assertThat(value, mather) 매개변수 : 값, 매처 
		// 코어 is() : 값이 같은 지 비교
		assertThat("match TEST", is(testMatcher()));
		//assertThat("match2 TEST", is(testMatcher()));
		
	}

	public Matcher<String> testMatcher() {
		return new BaseMatcher<String> () {
			//비교 함수
			public boolean matches(Object arg) {
				//instanceof 오브젝트 : 두개의 인스턴스가 같은 타입인지 비교
				//typeCompatibleWith 오브젝트 : 동일하거나 상위 인터페이스 타입인지 비교
				if (!(arg instanceof String)) {
					return false;
				}
				if (arg.equals("match TEST"))
					return true;
				
				return false;
			}
			// 에러 시 나오는 문구
			public void describeTo(Description arg) {
				arg.appendText("match TEST equal");
			}
			
		};
	}
}
