package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_BlackWaveClearCount extends Common {
	private int PlanetIdx;
	private int BlackWaveIdx;
	private int Difficulty;
	private int WaveNumber;
	private int WaveEnter;
	private int WaveClear;
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
	public int getWaveNumber() {
		return WaveNumber;
	}
	public void setWaveNumber(int waveNumber) {
		WaveNumber = waveNumber;
	}
	public int getWaveEnter() {
		return WaveEnter;
	}
	public void setWaveEnter(int waveEnter) {
		WaveEnter = waveEnter;
	}
	public int getWaveClear() {
		return WaveClear;
	}
	public void setWaveClear(int waveClear) {
		WaveClear = waveClear;
	}
}
