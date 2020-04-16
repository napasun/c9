package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_CharCountByCartelLev extends Common {
	private int CartelLev;
	public int getCartelLev() {
		return CartelLev;
	}
	public void setCartelLev(int cartelLev) {
		CartelLev = cartelLev;
	}
	public int getCharCount() {
		return CharCount;
	}
	public void setCharCount(int charCount) {
		CharCount = charCount;
	}
	private int CharCount;
}
