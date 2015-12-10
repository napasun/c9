package khj.study.junit.summary;

//static 으로 선언
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import khj.study.junit.cal.Calculater;

public class first {
	private int temp_value;
	/**
	 * 테스트 메스드 정리
	 * 1. @Test 어노테이션으로 정의
	 * public 형
	 * void 리턴
	 * 매개변수 없음
	 * */
	@Test
	public void firstTest() {
		Calculater cal = new Calculater();
		//두개의 값 비교 단정문
		assertEquals(cal.add(8, 4), 12);
		assertFalse("error", false);
	}
	/**
	 * @Before 셋업 함수 정의 @After 티어 다운
	 * 테스트 클래스 초기화 함수
	 * public void 매개변수 없음
	 * @Before @After 메소드 중복가능 전부 실행은 하지만 실행 순서는 보장 못함
	 * */
	@Before
	public void befor() {
		temp_value = 12;
		System.out.println(temp_value);
	}
	
	@After
	public void after() {
		temp_value = 13;
		System.out.println(temp_value);
	}
	
	/**
	 * @Ignore
	 * 테스트 무시
	 **/
	@Ignore
	@Test
	public void ignoreTest() {
		assertEquals(temp_value, 15);
	}
}
