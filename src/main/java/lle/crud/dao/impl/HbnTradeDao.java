package lle.crud.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import lle.crud.dao.TradeDao;
import lle.crud.model.Trade;
import lle.crud.model.User;

@Repository
public class HbnTradeDao extends AbstractHbnDao<Trade> implements TradeDao {

	/**
	 * @param criteria
	 * @return
	 */
	public List<Trade> getTradeByCriteria(HashMap<String, String> criteria) {
		List<Trade> trades = null;
		Set<Entry<String,String>> set = criteria.entrySet();
		StringBuilder sb = new StringBuilder();
		int i=0;
		
		for (Entry<String, String> entry : set) {
			String con = "";
			if (i++ == 0)
				con = String.format(" %s = :%s", entry.getKey(), entry.getKey());
			else 
				con = String.format("AND %s = :%s", entry.getKey(), entry.getKey());
			sb.append(con);
		}
		Query query = getSession().createQuery("from Trade where "+sb.toString());
		
		for (Entry<String, String> entry : set) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		trades = query.getResultList();
		return trades;

	}
}
