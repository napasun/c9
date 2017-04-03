package study.java.log;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogStudy {
	//JUL(java.util.logging)
	//slf4j-simple, log4j, logback

	
	
	public static void main(String[] args) {
		//정적
		Logger.getGlobal().severe("global info");
		
		//기본
		Logger logger = Logger.getLogger(LogStudy.class.getName());
		
		//레벨
		//severe, warning, info, config, fine, finer, finest
		
		logger.setLevel(Level.ALL);		//로그 레벨 설정
		
		logger.severe("severe test");	//심각
		logger.warning("warning test");	//경고
		logger.info("info test");		//정보
		logger.config("config test");
		logger.fine("fine test");
		logger.finer("finer test");
		logger.finest("finest test");
		
		//공통
		logger.log(Level.INFO, "log info test");
		
		
	
		
		
		//파일 저장
		
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(LogStudy.class.getName() + ".log");
		} catch (SecurityException | IOException e) {
			 logger.log(Level.SEVERE, null, e);
		};
		
		logger.addHandler(fileHandler);	
		
		logger.entering("entering class test", "entering method test", "test");	//finer ENTRY
		logger.exiting("exiting class test", "exiting method test", "test"); // RETURN
		
		logger.info("file info test");
		logger.config("file config test");
		logger.fine("file fine test");
		logger.finer("file finer test");
		logger.finest("file finest test");
		
		logger.removeHandler(fileHandler);

		
		
		
		//포멧
		Formatter formatter = new Formatter() {
			@Override
			public String format(LogRecord record) {
				String message = record.getMessage();
				message += "\n";
				return message;
			}
		};
		
		
		FileHandler fileHandler2 = null;
		
		try {//%h 사용자 홈 디렉토리, %t 시스템의 임시 디렉토리, %u 고유번호, %g 시퀀스 번호
			fileHandler2 = new FileHandler(LogStudy.class.getName() + "_formatter.log.%g");
			fileHandler2.setLevel(Level.CONFIG);
		} catch (SecurityException | IOException e) {
			 logger.log(Level.SEVERE, null, e);
		};
		fileHandler2.setFormatter(formatter);
		logger.addHandler(fileHandler2);
		
		logger.info("file info test");
		logger.config("file config test");
		logger.fine("file fine test");
		logger.finer("file finer test");
		logger.finest("file finest test");
	}
}
