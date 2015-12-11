package khj.study.junit.summary;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import khj.study.junit.cal.Calculater;


/**
 * 파라미터화 테스트
 * 하나의 테스트를 여러번 반복 실행
 * @RunWith 애노테이션을 부여 Parameterized 클래스를 사용한다.
 * 테스트에 사용될 인스턴스 변수를 선언하고 @Parameters가 표시된 메서드가 하나 필요하다.
 * 값의 갯수와 유일한 public 생성자와
 * */
@RunWith(value=Parameterized.class)
public class ParameterTest {
	private int expected;
	private int value_1;
	private int value_2;
	
	@Parameters
	public static Collection<Integer[]> getParameter() {
		return Arrays.asList(new Integer[][] {
			{2, 1, 1}
			, {3, 2, 1}
			, {5, 3, 2}
		});
	}
	
	public ParameterTest(int expected, int value_1, int value_2) {
		this.expected = expected;
		this.value_1 = value_1;
		this.value_2 = value_2;
	}
	
	@Test
	public void paramsterTest() {
		Calculater calc = new Calculater();
		assertEquals(expected, calc.add(value_1, value_2));
	}
}
