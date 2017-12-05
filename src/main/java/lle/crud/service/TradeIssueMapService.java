package lle.crud.service;

import java.util.List;

import lle.crud.model.TradeIssueMap;

public interface TradeIssueMapService {
	
	public void createTradeIssueMap(TradeIssueMap tradeIssue);
	
	/**@author LuanNgu
	 * @param list
	 */
	public void createTradeIssueMap(List<TradeIssueMap> list);
	
	public void deleteTradeIssueMap(TradeIssueMap tradeIssue);
	
	public void updateTradeIssueMap(TradeIssueMap tradeIssue);

}
