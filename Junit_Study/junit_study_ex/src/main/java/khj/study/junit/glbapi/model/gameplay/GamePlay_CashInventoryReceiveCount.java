package khj.study.junit.glbapi.model.gameplay;

import khj.study.junit.glbapi.model.Common;

public class GamePlay_CashInventoryReceiveCount extends Common {
	private int ItemIdx;
	private int ReceiveCount;
	public int getItemIdx() {
		return ItemIdx;
	}
	public void setItemIdx(int itemIdx) {
		ItemIdx = itemIdx;
	}
	public int getReceiveCount() {
		return ReceiveCount;
	}
	public void setReceiveCount(int receiveCount) {
		ReceiveCount = receiveCount;
	}
}
