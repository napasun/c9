package board.model.boardcontent;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import board.model.board.boardcontent.DefaultBoardContent;

@RunWith(Parameterized.class)
public class After2DefaultBoardContentTest {
	private static Calendar calendar;
	private DefaultBoardContent boardContent;
	private boolean checkValue;

	private static DefaultBoardContent setCalendar(int date, int hour) {
		calendar = Calendar.getInstance();

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

	public After2DefaultBoardContentTest(DefaultBoardContent boardContent, boolean checkValue) {
		this.boardContent = boardContent;
		this.checkValue = checkValue;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ setCalendar(Date(0), Hour(0)), true } //
				, { setCalendar(Date(-1), Hour(0)), true } //
				, { setCalendar(Date(-2), Hour(1)), true } //
				, { setCalendar(Date(-3), Hour(0)), false } //
				, { setCalendar(Date(-4), Hour(0)), false } //
		});
	}

	@Test
	public void NewTagTest() {
		assertEquals(boardContent.getNewTag(), checkValue);
	}
}
