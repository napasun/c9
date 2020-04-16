package khj.study.junit.glbapi;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import khj.study.junit.glbapi.model.StatisticsCommon;
import khj.study.junit.glbapi.model.gameeconomy.GameEconomyList;
import khj.study.junit.glbapi.model.gameeconomy.GameEconomy_AgentshopTopTrader;
import khj.study.junit.glbapi.service.gameeconomy.dao.GameEconomyTWDao;

public class GameEconomyDaoTest {
	GameEconomy_AgentshopTopTrader common;
	GameEconomyTWDao TWDao;
	
	@Before
	public void beforeGameEconomyTWDao() {
		common = new GameEconomy_AgentshopTopTrader();
		Calendar date = Calendar.getInstance();
		date.add(Calendar.MONTH, -1);
		common.setDate(date.getTime());
		
		TWDao = mock(GameEconomyTWDao.class);
		
		List<StatisticsCommon> list = new ArrayList<StatisticsCommon> ();
		list.add(new GameEconomy_AgentshopTopTrader(new Date(), 1, 6, 11, 16));
		list.add(new GameEconomy_AgentshopTopTrader(new Date(), 2, 7, 12, 17));
		list.add(new GameEconomy_AgentshopTopTrader(new Date(), 3, 8, 13, 18));
		list.add(new GameEconomy_AgentshopTopTrader(new Date(), 4, 9, 14, 19));
		list.add(new GameEconomy_AgentshopTopTrader(new Date(), 5, 10, 15, 20));		
		
		when(TWDao.getList(common, "LS", "AgentshopTopTrader")).thenReturn(list);
	}
	
	@Test
	public void testMockSelect() {
		List<StatisticsCommon> list = TWDao.getList(common, "LS", "AgentshopTopTrader");
		assertEquals(list.size(), 5);
	}
	
	@Test
	public void testEconomyList() {
		GameEconomyList[] EconomyList = GameEconomyList.values();
		assertEquals(10, EconomyList.length);
	}
}
