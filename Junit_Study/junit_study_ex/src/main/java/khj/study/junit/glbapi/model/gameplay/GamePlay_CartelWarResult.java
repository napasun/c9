package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_CartelWarResult extends Common {
	private int CartelType;
	private long CartelPoint;
	public int getCartelType() {
		return CartelType;
	}
	public void setCartelType(int cartelType) {
		CartelType = cartelType;
	}
	public long getCartelPoint() {
		return CartelPoint;
	}
	public void setCartelPoint(long cartelPoint) {
		CartelPoint = cartelPoint;
	}
}
