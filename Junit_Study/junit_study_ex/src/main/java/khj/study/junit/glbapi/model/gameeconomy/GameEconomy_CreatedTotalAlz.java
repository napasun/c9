package khj.study.junit.glbapi.model.gameeconomy;

import khj.study.junit.glbapi.model.Common;

public class GameEconomy_CreatedTotalAlz extends Common {
	private long CreatedAlzAmount;
	private long NPCShop;
	private long QuestReward;
	private long DungeonClear;
	private long DailyLoginReward;
	
	public long getCreatedAlzAmount() {
		return CreatedAlzAmount;
	}
	public void setCreatedAlzAmount(long createdAlzAmount) {
		CreatedAlzAmount = createdAlzAmount;
	}
	public long getNPCShop() {
		return NPCShop;
	}
	public void setNPCShop(long nPCShop) {
		NPCShop = nPCShop;
	}
	public long getQuestReward() {
		return QuestReward;
	}
	public void setQuestReward(long questReward) {
		QuestReward = questReward;
	}
	public long getDungeonClear() {
		return DungeonClear;
	}
	public void setDungeonClear(long dungeonClear) {
		DungeonClear = dungeonClear;
	}
	public long getDailyLoginReward() {
		return DailyLoginReward;
	}
	public void setDailyLoginReward(long dailyLoginReward) {
		DailyLoginReward = dailyLoginReward;
	}
}
