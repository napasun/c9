package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_ItemDropCount extends Common {
	private int ItemIdx;
	private int Count;
	public int getItemIdx() {
		return ItemIdx;
	}
	public void setItemIdx(int itemIdx) {
		ItemIdx = itemIdx;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
}
