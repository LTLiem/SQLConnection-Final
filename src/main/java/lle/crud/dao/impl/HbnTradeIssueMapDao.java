package lle.crud.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import lle.crud.dao.TradeIssueMapDao;
import lle.crud.model.TradeHeader;
import lle.crud.model.TradeIssueMap;
import lle.crud.model.TradeIssueMapKey;

@Repository
public class HbnTradeIssueMapDao extends AbstractHbnDao<TradeIssueMap> implements TradeIssueMapDao {
	
	static int MAX_LIMIT_BATCH = 50;

	/**
	 * @author LuanNgu
	 * @param list
	 */
	public void create(List<TradeIssueMap> list) {
		// TODO Auto-generated method stub
		int size = list.size();
		for (int i = 0; i < size; i++) {
	
			createOrUpdate(list.get(i));
		
			if (i % MAX_LIMIT_BATCH == 0) {
				// flush a batch of inserts and release memory:
				getSession().flush();
				getSession().clear();
			}

		}

	}

	public TradeIssueMap getByTradeIssueKey(TradeIssueMapKey tradeIssueMapKey) {
		TradeIssueMap tradeIssueMap = null;
		
		tradeIssueMap = (TradeIssueMap)getSession()
				.createQuery("from TradeIssueMap where tradeIssueMapKey.tradeNb = :tradeNb "
						+ "and tradeIssueMapKey.issueId = :issueId")
				.setParameter("tradeNb", tradeIssueMapKey.getTradeNb())
				.setParameter("issueId", tradeIssueMapKey.getIssueId())				
				.uniqueResult();

		return tradeIssueMap;
	}
}
