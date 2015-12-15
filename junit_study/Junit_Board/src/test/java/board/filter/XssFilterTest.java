package board.filter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XssFilterTest {
	String content;
	
	@Before
	public void setUp() {
		content = "<script> alert(); <script>";
	}
	
	@Test
	public void conventTest () {
		String conventStr = XssFilter.convert(content);
		
		assertEquals(conventStr.indexOf("<"), -1);		
	}
}
