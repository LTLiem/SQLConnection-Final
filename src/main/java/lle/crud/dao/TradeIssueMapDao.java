package lle.crud.dao;

import java.util.List;

import lle.crud.model.TradeIssueMap;

public interface TradeIssueMapDao extends Dao<TradeIssueMap> {
	//Add specified method for Trade and Issue relation
	public void create(List<TradeIssueMap> list);
}
