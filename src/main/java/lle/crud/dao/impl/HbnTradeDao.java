package lle.crud.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Set;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import lle.crud.dao.TradeDao;
import lle.crud.model.Trade;

@Repository
public class HbnTradeDao extends AbstractHbnDao<Trade> implements TradeDao {

	/**
	 * @author LuanNgu
	 * @param criteria
	 * @return list of trades
	 */
	public List<Trade> getTradeByCriteria(HashMap<String, String> criteria) {
		List<Trade> trades = null;
		Set<Entry<String, String>> set = criteria.entrySet();
		StringBuilder sb = new StringBuilder();
		int i = 0;

		for (Entry<String, String> entry : set) {
			String con = "";
			if (i++ > 0)
				con = String.format(" AND %s = :%s", entry.getKey().toLowerCase(), entry.getKey());
			else
				con = String.format(" %s = :%s", entry.getKey().toLowerCase(), entry.getKey());
			sb.append(con);
		}
		Query query = getSession().createQuery("from Trade where " + sb.toString());

		for (Entry<String, String> entry : set) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		trades = query.getResultList();
		return trades;

	}
}
