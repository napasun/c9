package newdate;

import java.time.Instant;
import java.time.Duration;
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
	
	static void Instant() {		//절대시간
		Instant instant = Instant.now();	//영국 그라니치 천문대 시간
		System.out.println(instant);
	}
	
	static void duration () {	// LocalDateTime을 사용, 시간의 차이
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
        
        //일, 시간, 분, 초, 나노초
        System.out.println(duration.toDays());	//781
        System.out.println(duration.toHours());	//18753
	}
	
	static void period() {	//LocalDate에서 사용
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
	
	// 시간 비교
	// 얼마나 차이가 나는 지 Duration 연산과 비슷하지만 년, 원, 주까지 비교 가능하다.
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
	
	static void localDatePrint() {	//좀 더 보편적 값으로 출력된다.
		Date date = new Date();
		System.out.println(date); // Sun Jan 01 00:00:00 KST 2017
			
		LocalDate localdate = LocalDate.now();
		System.out.println(localdate);	// 2017-01-01
	}
	
	// 기존 Date를 초기화 할 경우 년도에는 1900년을 기준으로 이후 년도를 더한 값 넣고 월에는 -1을 한 월을 넣어야 했다.
	// LocalDate에서는 좀 더 명시적으로 날짜를 초기화 할 수 있다.
	static void localDateInit() {	
		Date date = new Date(117, 1, 1);	// 월이 1부터 시작한다.
		System.out.println(date);
		
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		//LocalDate.of(2017, Month.FEBRUARY, 1);
		System.out.println(localdate);
	}
	
	// 기존의 날짜 연산의 경우 Calendar 객체를 사용해야 했다.
	// LocalDate에서는 plus(Days|Months|Weeks|Years)를 제공한다.
	// 연산 메서드를 사용할 경우 원본을 유지하고 새로운 값을 리턴한다.
	static void localDateAdd() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 1, 1);
		cal.add(Calendar.DATE, 10);
		System.out.println(cal.getTime()); // Sat Feb 11 10:30:01 KST 2017
		
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		localdate.plusDays(10);
		System.out.println(localdate);	// 2017-02-01, 기존 데이터를 유지한다.
		System.out.println(localdate.plusDays(10));	// 2017-02-11
	}
	
	// 기타등등
	static void localDateMethod () {
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		System.out.println(localdate.getDayOfMonth());	//1
		System.out.println(localdate.getDayOfYear());	//32
	}
	
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
	
	static void localDateTimeInit() {
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		LocalTime localtime = LocalTime.of(1, 2);
		
		LocalDateTime localDateTime = LocalDateTime.of(localdate, localtime);
		System.out.println(localDateTime);	// 2017-02-01T01:02
	}
	
	
	static void zoneld() {
		ZonedDateTime zoned = ZonedDateTime.of(2017,  1, 1, 1, 1, 0, 0, ZoneId.of("America/New_York"));
		ZonedDateTime zoned2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York"));
		System.out.println(zoned2);
		//다른 나라의 시간값을 가져오는 예제
		System.out.println(Instant.now().atZone(ZoneId.of("America/New_York")));
	}
	
	
	static void datetimeformatter() {
		LocalDateTime localDateTime = LocalDateTime.of(2017, 2, 1, 1, 2);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm");
		localDateTime.format(formatter);
		
		System.out.println(localDateTime);//2017-02-01T01:02
		System.out.println(localDateTime.format(formatter));
		//기본 타입
		System.out.println(localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		//System.out.println(localDateTime.format(DateTimeFormatter.ISO_INSTANT));	//에러
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
