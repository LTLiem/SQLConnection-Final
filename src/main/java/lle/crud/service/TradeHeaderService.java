package lle.crud.service;

import java.util.List;

import lle.crud.model.TradeHeader;
import lle.crud.model.TradeHeaderKey;

public interface TradeHeaderService {
	
	public void createTradeHeader(TradeHeader tradeHeader);
	
	public void deleteTradeHeader(TradeHeader tradeHeader);
	
	public void updateTradeHeader(TradeHeader tradeHeader);
	
	public List<TradeHeader> getAllTradeHeader(); 
	
	public TradeHeader getTradeHeaderByFGT(TradeHeaderKey key);
	
}
