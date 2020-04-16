package khj.study.junit.glbapi.service.gameeconomy.service;

import java.util.List;

import khj.study.junit.glbapi.model.StatisticsCommon;

public interface GameEconomyService {
	List<StatisticsCommon> getList(StatisticsCommon common, String nationCode, String tableName);
}
