package khj.study.junit.glbapi.service.gameeconomy.dao;

import java.util.List;

import khj.study.junit.glbapi.model.gameeconomy.GameEconomy_AgentshopTopTrader;



public interface GameEconomyGLBDao extends GameEconomyDao {
	List<GameEconomy_AgentshopTopTrader> getAgentshopTopTrade (String nationCode);
}
