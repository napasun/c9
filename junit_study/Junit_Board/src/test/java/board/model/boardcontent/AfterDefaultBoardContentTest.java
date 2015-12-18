package board.model.boardcontent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import board.model.board.boardcontent.DefaultBoardContent;

public class AfterDefaultBoardContentTest {
	private static Calendar calendar;	
	private static ArrayList<DefaultBoardContent> newTrue;
	private static ArrayList<DefaultBoardContent> falseTrue;
	
	private static DefaultBoardContent setCalendar(int date, int hour) {
		calendar =  Calendar.getInstance();
		
		calendar.add(Calendar.DATE, date);
		calendar.add(Calendar.HOUR, hour);
		
		return new DefaultBoardContent(calendar);
	}
	
	private static int Date(int date) {
		return date;
	}
	
	private static int Hour(int hour) {
		return hour;
	}
	
	@BeforeClass
	public static void NewTagSetupTrue() {
		newTrue = new ArrayList<DefaultBoardContent>();
		
		newTrue.add(setCalendar(Date(0), Hour(0)));
		newTrue.add(setCalendar(Date(-1), Hour(0)));
		newTrue.add(setCalendar(Date(-2), Hour(1)));
	}
	
	@BeforeClass
	public static void NewTagSetupFalse() {
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
