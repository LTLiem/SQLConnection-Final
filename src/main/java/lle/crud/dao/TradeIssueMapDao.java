package lle.crud.dao;

import java.util.List;

import lle.crud.model.TradeIssueMap;
import lle.crud.model.TradeIssueMapKey;

public interface TradeIssueMapDao extends Dao<TradeIssueMap> {
	//Add specified method for Trade and Issue relation
	public void create(List<TradeIssueMap> list);
	
	public TradeIssueMap getByTradeIssueKey(TradeIssueMapKey tradeIssueMapKey);
}
