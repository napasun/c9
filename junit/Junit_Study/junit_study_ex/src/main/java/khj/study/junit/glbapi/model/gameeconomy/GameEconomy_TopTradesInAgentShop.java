package khj.study.junit.glbapi.model.gameeconomy;

import khj.study.junit.glbapi.model.Common;

public class GameEconomy_TopTradesInAgentShop extends Common {
	private int ItemIdx;
	private int ItemCount;
	private long AveragePrice;
	
	public int getItemIdx() {
		return ItemIdx;
	}
	public void setItemIdx(int itemIdx) {
		ItemIdx = itemIdx;
	}
	public int getItemCount() {
		return ItemCount;
	}
	public void setItemCount(int itemCount) {
		ItemCount = itemCount;
	}
	public long getAveragePrice() {
		return AveragePrice;
	}
	public void setAveragePrice(long averagePrice) {
		AveragePrice = averagePrice;
	}
}
