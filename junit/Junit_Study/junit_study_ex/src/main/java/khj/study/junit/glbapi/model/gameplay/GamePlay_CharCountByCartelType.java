package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_CharCountByCartelType extends Common {
	private int CartelType;
	private int CharCount;
	public int getCartelType() {
		return CartelType;
	}
	public void setCartelType(int cartelType) {
		CartelType = cartelType;
	}
	public int getCharCount() {
		return CharCount;
	}
	public void setCharCount(int charCount) {
		CharCount = charCount;
	}
}
