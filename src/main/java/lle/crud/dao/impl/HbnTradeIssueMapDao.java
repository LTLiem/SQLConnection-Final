package lle.crud.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lle.crud.dao.TradeIssueMapDao;
import lle.crud.model.TradeIssueMap;

@Repository
public class HbnTradeIssueMapDao extends AbstractHbnDao<TradeIssueMap> implements TradeIssueMapDao {

	@Autowired
	SessionFactory sessionFactory;
	static int MAX_LIMIT_BATCH = 50;

	/**
	 * @author LuanNgu
	 * @param list
	 */
	public void create(List<TradeIssueMap> list) {
		// TODO Auto-generated method stub
		int size = list.size();
		for (int i = 0; i < size; i++) {
	
			if (!exists(list.get(i).getTradeIssueMapKey()))
				create(list.get(i));
		
			if (i % MAX_LIMIT_BATCH == 0) {
				// flush a batch of inserts and release memory:
				getSession().flush();
				getSession().clear();
			}

		}

	}
}
