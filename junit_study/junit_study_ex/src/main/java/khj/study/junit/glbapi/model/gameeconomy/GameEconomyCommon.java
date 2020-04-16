package khj.study.junit.glbapi.model.gameeconomy;

import khj.study.junit.glbapi.model.Common;

public class GameEconomyCommon extends Common{
	protected long TotalAmount;
	protected int CharacterIdx;
	protected int UserIdx;
	
	public long getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		TotalAmount = totalAmount;
	}
	public int getCharacterIdx() {
		return CharacterIdx;
	}
	public void setCharacterIdx(int characterIdx) {
		CharacterIdx = characterIdx;
	}
	public int getUserIdx() {
		return UserIdx;
	}
	public void setUserIdx(int userIdx) {
		UserIdx = userIdx;
	}
}
