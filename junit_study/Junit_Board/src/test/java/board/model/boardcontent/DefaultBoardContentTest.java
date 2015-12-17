package board.model.boardcontent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import board.model.board.boardcontent.DefaultBoardContent;

public class DefaultBoardContentTest {
	@Test
	public void newTagTest() {
		Calendar cal = Calendar.getInstance();
		
		DefaultBoardContent content = new DefaultBoardContent(cal.getTime());
		
		cal.add(Calendar.DATE, -1);
		DefaultBoardContent content2 = new DefaultBoardContent(cal.getTime());
		
		cal.add(Calendar.DATE, -1);
		cal.add(Calendar.HOUR, 1);
		DefaultBoardContent content3 = new DefaultBoardContent(cal.getTime());
		
		cal.add(Calendar.DATE, -1);
		DefaultBoardContent content4 = new DefaultBoardContent(cal.getTime());
		
		
		assertTrue(content.getNewTag());
		assertTrue(content2.getNewTag());
		assertTrue(content3.getNewTag());
		assertFalse(content4.getNewTag());	
	}
	
	
	
	
	@Test
	public void dateFormatTest() {
		Calendar cal = Calendar.getInstance();
		DefaultBoardContent content = new DefaultBoardContent(cal.getTime());
		
		String dateStr = content.getCreateDate("YYYY");
		
		assertEquals(dateStr, String.valueOf(cal.get(Calendar.YEAR)));
		assertNotEquals(dateStr, "2014");
	}
	
	
}
