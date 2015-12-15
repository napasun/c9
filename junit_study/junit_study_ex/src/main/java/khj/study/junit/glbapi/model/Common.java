package khj.study.junit.glbapi.model;

import java.util.Date;

public class Common implements StatisticsCommon{
	protected Date Date;
	protected int RealmIdx;
	protected Integer Hour;
	
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getRealmIdx() {
		return RealmIdx;
	}
	public void setRealmIdx(int realmIdx) {
		RealmIdx = realmIdx;
	}
	public Integer getHour() {
		return Hour;
	}
	public void setHour(Integer hour) {
		Hour = hour;
	}
}
