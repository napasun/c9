package khj.study.junit.glbapi.model.gameeconomy;

import khj.study.junit.glbapi.model.Common;

public class GameEconomy_TotalAlzAmount extends Common {
	private long RemainAlzAmount;
	private long AgentShopAlz;
	private long InventoryAlz;
	private long MailAlz;
	private long WarehouseAlz;
	private long GuildwarehouseAlz;
	
	public long getRemainAlzAmount() {
		return RemainAlzAmount;
	}
	public void setRemainAlzAmount(long remainAlzAmount) {
		RemainAlzAmount = remainAlzAmount;
	}
	public long getAgentShopAlz() {
		return AgentShopAlz;
	}
	public void setAgentShopAlz(long agentShopAlz) {
		AgentShopAlz = agentShopAlz;
	}
	public long getInventoryAlz() {
		return InventoryAlz;
	}
	public void setInventoryAlz(long inventoryAlz) {
		InventoryAlz = inventoryAlz;
	}
	public long getMailAlz() {
		return MailAlz;
	}
	public void setMailAlz(long mailAlz) {
		MailAlz = mailAlz;
	}
	public long getWarehouseAlz() {
		return WarehouseAlz;
	}
	public void setWarehouseAlz(long warehouseAlz) {
		WarehouseAlz = warehouseAlz;
	}
	public long getGuildwarehouseAlz() {
		return GuildwarehouseAlz;
	}
	public void setGuildwarehouseAlz(long guildwarehouseAlz) {
		GuildwarehouseAlz = guildwarehouseAlz;
	}
}
