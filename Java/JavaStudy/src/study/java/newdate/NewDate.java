package study.java.newdate;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
//LocalDate, LocalTime, Instant, Duration, Period
public class NewDate {
	public static void main(String[] args) {
		//Instant();
		//duration ();
		//period();
		//chronoUnit();
		/*
		localDatePrint();
		localDateInit();
		localDateAdd();
		localDateMethod ();
		*/
		
		//localTimeInit();
		//localTimeAddAndMinus();
		
		//localDateTimeInit();
		//zoneld();
		datetimeformatter();
	}
	/**
	 * Instant
	 * */
	static void Instant() {		//�젅���떆媛�
		Instant instant = Instant.now();	//�쁺援� 洹몃씪�땲移� 泥쒕Ц�� �떆媛�
		System.out.println(instant);
	}
	/**
	 * Duration
	 * */
	static void duration () {	// LocalDateTime�쓣 �궗�슜, �떆媛꾩쓽 李⑥씠
        Duration oneHours = Duration.ofHours(1);
        System.out.println(oneHours.getSeconds());	//3600

        Duration oneHours2 = Duration.of(1, ChronoUnit.HOURS);
        System.out.println(oneHours2.getSeconds());	//3600

        Duration twoHours = Duration.ofHours(2);
        System.out.println(twoHours.toMinutes());	//120

        
        LocalDateTime oldDate = LocalDateTime.of(2015, Month.JANUARY, 1, 1, 1, 1);
        LocalDateTime newDate = LocalDateTime.of(2017, Month.FEBRUARY, 20, 10, 10, 10);

        System.out.println(oldDate);
        System.out.println(newDate);

        Duration duration = Duration.between(oldDate, newDate);
        
        //�씪, �떆媛�, 遺�, 珥�, �굹�끂珥�
        System.out.println(duration.toDays());	//781
        System.out.println(duration.toHours());	//18753
	}
	/**
	 * Period
	 * */
	static void period() {	//LocalDate�뿉�꽌 �궗�슜
        Period tenDays = Period.ofDays(10);
        System.out.println(tenDays.getDays()); //10

        Period period = Period.of(1, 2, 3);
        System.out.println(period.getYears());   //1
        System.out.println(period.getMonths());  //2
        System.out.println(period.getDays());    //3

        
        LocalDate oldDate = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate newDate = LocalDate.of(2017, Month.FEBRUARY, 10);

        System.out.println(oldDate);
        System.out.println(newDate);

        // check period between dates
        Period period2 = Period.between(oldDate, newDate);

        System.out.println(period2.getYears());		//2
        System.out.println(period2.getMonths());	//1
        System.out.println(period2.getDays());		//9
	}
	/**
	 * ChronoUnit
	 * */
	// �떆媛� 鍮꾧탳
	// �뼹留덈굹 李⑥씠媛� �굹�뒗 吏� Duration �뿰�궛怨� 鍮꾩듂�븯吏�留� �뀈, �썝, 二쇨퉴吏� 鍮꾧탳 媛��뒫�븯�떎.
	static void chronoUnit() {
		LocalDateTime oldDate = LocalDateTime.of(1987, Month.AUGUST, 4, 14, 24, 34);
        LocalDateTime newDate = LocalDateTime.of(2017, Month.FEBRUARY, 9, 10, 11, 12);

        System.out.println(oldDate);
        System.out.println(newDate);

        long years = ChronoUnit.YEARS.between(oldDate, newDate);
        long months = ChronoUnit.MONTHS.between(oldDate, newDate);
        long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
        long days = ChronoUnit.DAYS.between(oldDate, newDate);
        long hours = ChronoUnit.HOURS.between(oldDate, newDate);
        long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
        long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
        long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
        long nano = ChronoUnit.NANOS.between(oldDate, newDate);

        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milis + " milis");
        System.out.println(nano + " nano");
        /*
         	1987-08-04T14:24:34
			2017-02-09T10:11:12
			29 years
			354 months
			1540 weeks
			10781 days
			258763 hours
			15525826 minutes
			931549598 seconds
			931549598000 milis
			931549598000000000 nano
         * */
	}
	/**
	 * LocalDate
	 * */
	static void localDatePrint() {	//醫� �뜑 蹂댄렪�쟻 媛믪쑝濡� 異쒕젰�맂�떎.
		Date date = new Date();
		System.out.println(date); // Sun Jan 01 00:00:00 KST 2017
			
		LocalDate localdate = LocalDate.now();
		System.out.println(localdate);	// 2017-01-01
	}
	// 湲곗〈 Date瑜� 珥덇린�솕 �븷 寃쎌슦 �뀈�룄�뿉�뒗 1900�뀈�쓣 湲곗��쑝濡� �씠�썑 �뀈�룄瑜� �뜑�븳 媛� �꽔怨� �썡�뿉�뒗 -1�쓣 �븳 �썡�쓣 �꽔�뼱�빞 �뻽�떎.
	// LocalDate�뿉�꽌�뒗 醫� �뜑 紐낆떆�쟻�쑝濡� �궇吏쒕�� 珥덇린�솕 �븷 �닔 �엳�떎.
	static void localDateInit() {	
		Date date = new Date(117, 1, 1);	// �썡�씠 1遺��꽣 �떆�옉�븳�떎.
		System.out.println(date);
		
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		//LocalDate.of(2017, Month.FEBRUARY, 1);
		System.out.println(localdate);
	}
	// 湲곗〈�쓽 �궇吏� �뿰�궛�쓽 寃쎌슦 Calendar 媛앹껜瑜� �궗�슜�빐�빞 �뻽�떎.
	// LocalDate�뿉�꽌�뒗 plus(Days|Months|Weeks|Years)瑜� �젣怨듯븳�떎.
	// �뿰�궛 硫붿꽌�뱶瑜� �궗�슜�븷 寃쎌슦 �썝蹂몄쓣 �쑀吏��븯怨� �깉濡쒖슫 媛믪쓣 由ы꽩�븳�떎.
	static void localDateAdd() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 1, 1);
		cal.add(Calendar.DATE, 10);
		System.out.println(cal.getTime()); // Sat Feb 11 10:30:01 KST 2017
		
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		localdate.plusDays(10);
		System.out.println(localdate);	// 2017-02-01, 湲곗〈 �뜲�씠�꽣瑜� �쑀吏��븳�떎.
		System.out.println(localdate.plusDays(10));	// 2017-02-11
	}
	// 湲고��벑�벑
	static void localDateMethod () {
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		System.out.println(localdate.getDayOfMonth());	//1
		System.out.println(localdate.getDayOfYear());	//32
	}
	/**
	 * LocalTime
	 * */
	static void localTimeInit () {
		LocalTime localtime1 = LocalTime.of(1, 2);
		System.out.println(localtime1);	// 01:02
		
		LocalTime localtime2 = LocalTime.of(1, 2, 3);
		System.out.println(localtime2);	// 01:02:03
		
		LocalTime localtime3 = LocalTime.of(1, 2, 3, 4);
		System.out.println(localtime3);	// 01:02:03.000000004
	}
	
	static void localTimeAddAndMinus () {
		LocalTime localtime1 = LocalTime.of(1, 2);
		System.out.println(localtime1);	// 01:02
		
		System.out.println(localtime1.plusHours(1));	// 02:02
		System.out.println(localtime1.plusMinutes(2));	// 01:04
		System.out.println(localtime1.plusSeconds(3));	// 01:02:03
		System.out.println(localtime1.plusNanos(4));	// 01:02:00.000000004
		
		System.out.println(localtime1.minusMinutes(1));	//01:01
	}
	/**
	 * LocalDateTime
	 * */
	static void localDateTimeInit() {
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		LocalTime localtime = LocalTime.of(1, 2);
		
		LocalDateTime localDateTime = LocalDateTime.of(localdate, localtime);
		System.out.println(localDateTime);	// 2017-02-01T01:02
	}
	/**
	 * Zoned
	 * */
	static void zoneld() {
		ZonedDateTime zoned = ZonedDateTime.of(2017,  1, 1, 1, 1, 0, 0, ZoneId.of("America/New_York"));
		ZonedDateTime zoned2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York"));
		System.out.println(zoned2);
		//�떎瑜� �굹�씪�쓽 �떆媛꾧컪�쓣 媛��졇�삤�뒗 �삁�젣
		System.out.println(Instant.now().atZone(ZoneId.of("America/New_York")));
	}
	/**
	 * DateTimeFormatter
	 * */
	static void datetimeformatter() {
		LocalDateTime localDateTime = LocalDateTime.of(2017, 2, 1, 1, 2);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm");
		localDateTime.format(formatter);
		
		System.out.println(localDateTime);//2017-02-01T01:02
		System.out.println(localDateTime.format(formatter));
		//湲곕낯 ���엯
		System.out.println(localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		//System.out.println(localDateTime.format(DateTimeFormatter.ISO_INSTANT));	//�뿉�윭
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
		/*
		 	20170201
			2017-02-01
			2017-02-01T01:02:00
			2017-02-01
			2017-02-01T01:02:00
			01:02:00
		 */
	}
}
