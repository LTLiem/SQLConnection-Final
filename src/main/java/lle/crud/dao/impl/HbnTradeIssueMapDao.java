package lle.crud.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import lle.crud.dao.TradeIssueMapDao;
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

			if (!exists(list.get(i).getTradeIssueMapKey()))
				create(list.get(i));

			if (i % MAX_LIMIT_BATCH == 0) {
				// flush a batch of inserts and release memory:
				getSession().flush();
				getSession().clear();
			}

		}

	}

	public TradeIssueMap getByTradeIssueKey(TradeIssueMapKey tradeIssueMapKey) {
		TradeIssueMap tradeIssueMap = null;

		tradeIssueMap = (TradeIssueMap) getSession()
				.createQuery("from TradeIssueMap where tradeIssueMapKey.tradeNb = :tradeNb "
						+ "and tradeIssueMapKey.issueId = :issueId")
				.setParameter("tradeNb", tradeIssueMapKey.getTradeNb())
				.setParameter("issueId", tradeIssueMapKey.getIssueId()).uniqueResult();

		return tradeIssueMap;
	}

	/**
	 * @author LuanNgu
	 * @see lle.crud.dao.TradeIssueMapDao#insertTradeIssue(java.util.HashMap)
	 */
	public void insertTradeIssue(HashMap<String, String> groups) {
		/*
		 * INSERT INTO trade_issue (trade_nb, issue_id, input_date) (SELECT trade_nb,
		 * :issue_val as issue_id, now() FROM trade WHERE %%);
		 * Using for batches insertion (Form excel file)
		 */

		StatelessSession session = getStatelessSession();
		Transaction tx = null;
		String query_string = "INSERT INTO trade_issue (trade_nb, issue_id, input_date) "
				+ "(SELECT trade_nb, :issue_val as issue_id, now() FROM trade WHERE #crit#) "
				+ "ON DUPLICATE KEY UPDATE trade_nb=VALUES(trade_nb), issue_id=VALUES(issue_id)";
		HashMap<String, String> grp = new HashMap<>(groups);
		grp.remove("issue");
		Set<Entry<String, String>> set = grp.entrySet();
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
		query_string = query_string.replaceAll("#crit#", sb.toString());
		Query query = session.createNativeQuery(query_string);

		for (Entry<String, String> entry : set) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setParameter("issue_val", groups.get("issue"));

		try {
			tx = session.beginTransaction();
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<TradeIssueMap> getByCreatedUserId(Integer userId) {

		List<TradeIssueMap> result = new ArrayList<>();

		result = getSession().createQuery("from TradeIssueMap where userCreatedId = :userId")
				.setParameter("userId", userId).list();

		return result;
	}
}
