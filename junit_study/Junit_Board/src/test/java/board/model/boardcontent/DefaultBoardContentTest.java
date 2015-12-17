package board.model.boardcontent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
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
	
	private Calendar calendar;
	
	private ArrayList<DefaultBoardContent> newTrue;
	private ArrayList<DefaultBoardContent> falseTrue;
	
	private void setCalendar(int date, int hour) {
		calendar =  Calendar.getInstance();
		
		calendar.add(Calendar.DATE, date);
		calendar.add(Calendar.HOUR, hour);
	}
	
	private int Date(int date) {
		return date;
	}
	
	private int Hour(int hour) {
		return hour;
	}
	
	@Before
	public void NewTagSetupTrue() {
		newTrue = new ArrayList<DefaultBoardContent>();
		
		setCalendar(Date(0), Hour(0));
		newTrue.add(new DefaultBoardContent(calendar));
		setCalendar(Date(-1), Hour(0));
		newTrue.add(new DefaultBoardContent(calendar));
		setCalendar(Date(-2), Hour(1));
		newTrue.add(new DefaultBoardContent(calendar));
	}
	
	@Before
	public void NewTagSetupFalse() {
		falseTrue = new ArrayList<DefaultBoardContent>();
		
		setCalendar(Date(-3), Hour(0));
		falseTrue.add(new DefaultBoardContent(calendar));
	}
	
	@Test
	public void afterNewTagTest() {
		for (DefaultBoardContent content : newTrue) {
			assertTrue("새 글이 아닙니다. : " + content.getCreateDate(), content.getNewTag());
		}
		
		for (DefaultBoardContent content : falseTrue) {
			assertFalse("새 글 입니다. : " + content.getCreateDate(), content.getNewTag());
		}
	}
}
