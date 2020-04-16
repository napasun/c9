package khj.study.junit.glbapi.service.gameeconomy.service;

import java.util.List;

import khj.study.junit.glbapi.model.StatisticsCommon;
import khj.study.junit.glbapi.service.gameeconomy.dao.GameEconomyTWDao;

//@Service
public class GameEconomyServiceImpl implements GameEconomyService {
	/*@Autowired */GameEconomyTWDao gameEconomyDao;
	
	public List<StatisticsCommon> getList(StatisticsCommon common
			, String nationCode
			, String tableName) {
		return gameEconomyDao.getList(common, nationCode, tableName);
	}

}
