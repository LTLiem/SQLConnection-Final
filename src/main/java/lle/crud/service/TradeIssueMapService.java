package lle.crud.service;

import java.util.HashMap;
import java.util.List;

import lle.crud.model.TradeIssueMap;
import lle.crud.model.TradeIssueMapKey;

public interface TradeIssueMapService {
	
	public void createTradeIssueMap(TradeIssueMap tradeIssue);
	
	/**@author LuanNgu
	 * @param list
	 */
	public void createTradeIssueMap(List<TradeIssueMap> list);
	
	public void deleteTradeIssueMap(TradeIssueMap tradeIssue);
	
	public void updateTradeIssueMap(TradeIssueMap tradeIssue);
	
	public TradeIssueMap getByTradeIssueKey(TradeIssueMapKey tradeIssueMapKey);
	
	/** @author LuanNgu
	 * @param groups properties of trade
	 * Insert by criteria
	 */
	public void insertTradeIssue(HashMap<String,String> groups);

}
