package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_EnchantResult extends Common {
	private int ItemIdx;
	private int EnchantLev;
	private int TryCount;
	private int SuccessCount;
	public int getItemIdx() {
		return ItemIdx;
	}
	public void setItemIdx(int itemIdx) {
		ItemIdx = itemIdx;
	}
	public int getEnchantLev() {
		return EnchantLev;
	}
	public void setEnchantLev(int enchantLev) {
		EnchantLev = enchantLev;
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
}
