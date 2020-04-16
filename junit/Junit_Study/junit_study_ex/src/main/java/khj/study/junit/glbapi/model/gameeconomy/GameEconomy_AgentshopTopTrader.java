package khj.study.junit.glbapi.model.gameeconomy;

import java.util.Date;


public class GameEconomy_AgentshopTopTrader extends GameEconomyCommon {
	public GameEconomy_AgentshopTopTrader() {}
	public GameEconomy_AgentshopTopTrader(Date Date, int RealmIdx, long TotalAmount, int CharacterIdx, int UserIdx) {
		this.Date = Date;
		this.RealmIdx = RealmIdx;
		this.TotalAmount = TotalAmount;
		this.CharacterIdx = CharacterIdx;
		this.UserIdx = UserIdx;
	}
}
