package khj.study.junit.glbapi.model.gameplay;

public enum GamePlayList {
	BattlefieldRankCharCount("Date,RealmIdx,BattlefieldIdx,BattlefieldRank,CharCount")
	, BattlefieldResult("Date,RealmIdx,BattlefieldIdx,LevSection,GameCount,ClearCount")
	, BlackWaveAttackForce("Date,PlanetIdx,BlackWaveIdx,Difficulty,OpenTime,Count")
	, BlackWaveClearCount("Date,PlanetIdx,BlackWaveIdx,Difficulty,WaveNumber,WaveEnter,WaveClear")
	, CartelWarResult("Date,RealmIdx,CartelType,CartelPoint")
	, CashInventoryReceiveCount("Date,ItemIdx,ReceiveCount")
	, CharCountByCartelLev("Date,RealmIdx,CartelLev,CharCount")
	, CharCountByCartelType("Date,RealmIdx,CartelType,CharCount")
	, DungeonClearCount("Date,RealmIdx,DungeonIdx,Difficulty,DungeonEnterCount,DungeonClearCount")
	, EnchantResult("Date,RealmIdx,ItemIdx,EnchantLev,TryCount,SuccessCount")
	, ForceCoreConvertResult("Date,RealmIdx,ConvertType,TryCount")
	, ItemDropCount("Date,RealmIdx,ItemIdx,Count")
	, ProductionGuildCharCount("Date,RealmIdx,ManufactureType,CharCount")
	, QuestClearCount("Date,RealmIdx,QuestType,QuestSubIdx,ClearCount")
	, RefurbishmentCount("Date,RealmIdx,ItemIdx,TryCount")
	, RuneConvertCount("Date,RealmIdx,ConvertType,TryCount,SuccessCount")
	, UpgradeCoreConvertResult("Date,RealmIdx,TryCount")
	, UsedForceCoreCount("Date,RealmIdx,ItemIdx,Count")
	;
	
	String column;
	
	private GamePlayList(String column) {
		this.column = column;
	}
	
	public String getName() {
		return this.name();
	}
	
	public String[] getColumnList() {
		return this.column.replaceAll(" ", "").split(",");
	}
}
