package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_BattlefieldResult extends Common {
	private int BattlefiledIdx;
	public int getBattlefiledIdx() {
		return BattlefiledIdx;
	}
	public void setBattlefiledIdx(int battlefiledIdx) {
		BattlefiledIdx = battlefiledIdx;
	}
	public int getLevSection() {
		return LevSection;
	}
	public void setLevSection(int levSection) {
		LevSection = levSection;
	}
	public int getGameCount() {
		return GameCount;
	}
	public void setGameCount(int gameCount) {
		GameCount = gameCount;
	}
	public int getClearCount() {
		return ClearCount;
	}
	public void setClearCount(int clearCount) {
		ClearCount = clearCount;
	}
	private int LevSection;
	private int GameCount;
	private int ClearCount;
}
