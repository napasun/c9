package khj.study.junit.glbapi.model.gameeconomy;

public enum GameEconomyList {
	AgentshopTopTrader("Date,RealmIdx,TotalAmount,CharacterIdx,UserIdx", true)
	, AlzAmount("Date,Hour,RealIdx,ActiveAlzAmount", true)
	, AlzTopMailer("Date,RealIdx,TotalAmount,CharacterIdx,UserIdx", true)
	, AlzTopTrader("Date,RealIdx,TotalAmount,CharacterIdx,UserIdx", true)
	, AveragePriceInAgentShop("Date,RealmIdx,ItemIdx,ItemCount,AveragePrice", true)
	, CreatedTotalAlz("Date,RealmIdx,CreatedAlzAmount,NPCShop,QuestReward,DungeonClear,DailyLoginReward", true)
	, NPCShopTopSeller("Date,RealmIdx,TotalAmount,CharacterIdx", true)
	, TopTradesInAgentShop("Date,RealmIdx,ItemIdx,ItemCount,AveragePrice", true)
	, TotalAlzAmount("Date,Hour,RealmIdx,RemainAlzAmount,AgentShopAlz,InventoryAlz,MailAlz,WarehouseAlz,GuildwarehouseAlz", true)
	, UsedTotalAlz("Date,RealmIdx,UsedAlzAmount,ForceCoreConversionFee", true);
	
	String column;
	boolean use;
	
	private GameEconomyList(String column, boolean use) {
		this.column = column;
		this.use = use;
	}
	
	public String getName() {
		return this.name();
	}
	
	public boolean getUse() {
		return this.use;
	}
	
	public String[] getColumnList() {
		return this.column.replaceAll(" ", "").split(",");
	}
}
