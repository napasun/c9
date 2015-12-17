package board.model.board.boardcontent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DefaultBoardContent {
	Integer boardNum;
	Integer boardContentNum;
	String subject;
	String content;
	Date createDate;
	
	public DefaultBoardContent() {}
	
	public DefaultBoardContent(Calendar cal) {
		this.createDate = cal.getTime();
	}
	
	public DefaultBoardContent(Date createDate) {
		this.createDate = createDate;
	}
	
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public Integer getBoardContentNum() {
		return boardContentNum;
	}
	public void setBoardContentNum(Integer boardContentNum) {
		this.boardContentNum = boardContentNum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	
	public String getCreateDate(String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(this.createDate);
	}
	
	public boolean getNewTag() {
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -2);
		
		return cal.getTime().before(this.createDate);
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
