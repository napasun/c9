package board.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class XssFilterTest {
	String content;
	
	@BeforeClass
	public void setUp() {
		content = "<script> alert(); </script>";
	}
	
	@Test
	public void conventTest () {
		String conventStr = XssFilter.convert(content);
		
		assertEquals(conventStr.indexOf("<"), -1);	
		assertNotEquals(conventStr.indexOf("&lt;"), -1);
	}
}
