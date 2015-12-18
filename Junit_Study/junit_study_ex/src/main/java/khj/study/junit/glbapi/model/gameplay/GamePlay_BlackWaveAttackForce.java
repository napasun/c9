package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_BlackWaveAttackForce extends Common {
	private int PlanetIdx;
	private int BlackWaveIdx;
	private int Difficulty;
	private int Opentime;
	private int Count;
	
	public int getPlanetIdx() {
		return PlanetIdx;
	}
	public void setPlanetIdx(int planetIdx) {
		PlanetIdx = planetIdx;
	}
	public int getBlackWaveIdx() {
		return BlackWaveIdx;
	}
	public void setBlackWaveIdx(int blackWaveIdx) {
		BlackWaveIdx = blackWaveIdx;
	}
	public int getDifficulty() {
		return Difficulty;
	}
	public void setDifficulty(int difficulty) {
		Difficulty = difficulty;
	}
	public int getOpentime() {
		return Opentime;
	}
	public void setOpentime(int opentime) {
		Opentime = opentime;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
}
