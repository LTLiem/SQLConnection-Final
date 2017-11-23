package lle.crud.dao;

import lle.crud.model.TradeHeader;
import lle.crud.model.TradeHeaderKey;

public interface TradeHeaderDao extends Dao<TradeHeader> {
	//Add specified method for Trade Header
	public TradeHeader getIssueByFGT(TradeHeaderKey key);
}
