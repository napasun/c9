package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_DungeonClearCount extends Common {
	private int DungeonIdx;
	private int Difficulty;
	private int DungeonEnterCount;
	private int DungeonClearCount;
	public int getDungeonIdx() {
		return DungeonIdx;
	}
	public void setDungeonIdx(int dungeonIdx) {
		DungeonIdx = dungeonIdx;
	}
	public int getDifficulty() {
		return Difficulty;
	}
	public void setDifficulty(int difficulty) {
		Difficulty = difficulty;
	}
	public int getDungeonEnterCount() {
		return DungeonEnterCount;
	}
	public void setDungeonEnterCount(int dungeonEnterCount) {
		DungeonEnterCount = dungeonEnterCount;
	}
	public int getDungeonClearCount() {
		return DungeonClearCount;
	}
	public void setDungeonClearCount(int dungeonClearCount) {
		DungeonClearCount = dungeonClearCount;
	}
}
