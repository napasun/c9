package khj.study.junit.summary;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 테스트 스위트 (suite)
 * 복수의 테스트를 묶을 수 있는 집합이다.
 * 사용자가 정의하지 않으면 테스트 러너가 자동으로 하나 만든 다.
 * 
 * 스위트의 스위트 가능
 * */
@RunWith(value=Suite.class)
@SuiteClasses(value= {FirstTest.class, MatcherTest.class}) // 담고자하는 테스트 클래스 선언
public class SuiteTest {

}
