package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_ForceCoreConvertResult extends Common {
	private int ConvertType;
	private int TryCount;
	public int getConvertType() {
		return ConvertType;
	}
	public void setConvertType(int convertType) {
		ConvertType = convertType;
	}
	public int getTryCount() {
		return TryCount;
	}
	public void setTryCount(int tryCount) {
		TryCount = tryCount;
	}
}
