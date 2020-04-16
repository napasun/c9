package khj.study.junit.summary;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
/**
 * InOrder : 함수가 순서대로 호출되었는 지 확인
 * */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
	
	@Mock
	private List mock;
	
	@Test
	public void mockTest() {
		mock.add("test");
		
		verify(mock).add("test");
	}
	
	@Test
	public void mockitoTest() {
		//mock 객체 생성
		List mockList = mock(List.class);
		
		mockList.add("test");
		mockList.removeAll();
		
		//지정한 함수가 호출되었는 지 여부 확인
		//verify(mockList).add("test");
		//지정한 횟수 만큼 호출 되었는 지 확인
		verify(mockList, times(1)).add("test");
		//지정한 횟수 만큼 최소한 실행 되어야 한다.
		verify(mockList, atLeast(1)).add("test");
		verify(mockList).removeAll();
	}
	/**
	 * when은 어떤 조건일 떄 어떤 값을 반환해야 하는 지 설정한다.
	 * */
	@SuppressWarnings("unchecked")
	@Test
	public void whenTest() {
		ArrayList<String> mockList = mock(ArrayList.class);
		
		when(mockList.get(0)).thenReturn("test", "test2");
		//에러 발생
		//when(mockList.get(1)).thenThrow(new RuntimeException());
		
		assertEquals("test", mockList.get(0));
		assertEquals("test2", mockList.get(0));
		//설정 삭제
		reset(mockList);
	}
	
	/**
	 * InOrder...
	 * */
}
