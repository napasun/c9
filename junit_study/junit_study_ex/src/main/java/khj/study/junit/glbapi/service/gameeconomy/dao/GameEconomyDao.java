package khj.study.junit.glbapi.service.gameeconomy.dao;

import java.util.List;

import khj.study.junit.glbapi.model.StatisticsCommon;


public interface GameEconomyDao {
	public List<StatisticsCommon> getList(/*@Param("common")*/StatisticsCommon common
			,/* @Param("nationCode") */String nationCode
			,/* @Param("tableName") */String tableName);
	
	public void add(/*@Param("common")*/StatisticsCommon common
			, /*@Param("nationCode") */String nationCode
			, /*@Param("columnList") */String[] columList
			, /*@Param("tableName") */String tableName);
}
