package lle.crud.dao;

import java.util.HashMap;
import java.util.List;

import lle.crud.model.Trade;

public interface TradeDao extends Dao<Trade> {
	//Add specified method for Trade
	/** @author LuanNgu
	 * @param criteria
	 * @return
	 */
	public List<Trade> getTradeByCriteria(HashMap<String,String> criteria);
}
