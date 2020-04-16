package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_RuneConvertCount extends Common {
	int ConvertType;
	int TryCount;
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
	public int getSuccessCount() {
		return SuccessCount;
	}
	public void setSuccessCount(int successCount) {
		SuccessCount = successCount;
	}
	int SuccessCount;
}
