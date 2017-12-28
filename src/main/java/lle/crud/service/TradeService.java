package lle.crud.service;

import java.util.HashMap;
import java.util.List;

import lle.crud.model.Trade;

public interface TradeService {
	
	public void createTrade(Trade trade);
	
	public void deleteTrade(Trade trade);
	
	public void updateTrade(Trade trade);
	
	public List<Trade> getAllTrade(); 
	
	public Trade getTradeByNb(String nb);
	
	public List<Trade> getTradeByCriteria(HashMap<String,String> criteria);
	
	public List<Trade> getLatestTrades(Integer limit);
}
