package board.model.boardcontent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import board.model.board.boardcontent.DefaultBoardContent;

public class AfterDefaultBoardContentTest {
	private Calendar calendar;	
	private ArrayList<DefaultBoardContent> newTrue, falseTrue;
	
	private DefaultBoardContent setCalendar(int date, int hour) {
		calendar =  Calendar.getInstance();
		
		calendar.add(Calendar.DATE, date);
		calendar.add(Calendar.HOUR, hour);
		
		return new DefaultBoardContent(calendar);
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
		
		newTrue.add(setCalendar(Date(0), Hour(0)));
		newTrue.add(setCalendar(Date(-1), Hour(0)));
		newTrue.add(setCalendar(Date(-2), Hour(1)));
	}
	
	@Before
	public void NewTagSetupFalse() {
		falseTrue = new ArrayList<DefaultBoardContent>();
		
		falseTrue.add(setCalendar(Date(-3), Hour(0)));
	}
	
	@Test
	public void NewTagTest() {
		for (DefaultBoardContent content : newTrue) {
			assertTrue("새 글이 아닙니다. : " + content.getCreateDate(), content.getNewTag());
		}
		
		for (DefaultBoardContent content : falseTrue) {
			assertFalse("새 글 입니다. : " + content.getCreateDate(), content.getNewTag());
		}
	}
}
