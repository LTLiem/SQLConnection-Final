package lle.crud.service;

import java.util.List;

import lle.crud.model.Trade;

public interface TradeService {
	
	public void createTrade(Trade trade);
	
	public void deleteTrade(Trade trade);
	
	public void updateTrade(Trade trade);
	
	public List<Trade> getAllTrade(); 
	
	public Trade getTradeByNb(String nb);
	
}
