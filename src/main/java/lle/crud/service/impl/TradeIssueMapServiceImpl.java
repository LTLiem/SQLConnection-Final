package lle.crud.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lle.crud.dao.TradeIssueMapDao;
import lle.crud.model.TradeIssueMap;
import lle.crud.model.TradeIssueMapKey;
import lle.crud.service.TradeIssueMapService;

@Service("TradeIssueMapService")
@Transactional
public class TradeIssueMapServiceImpl implements TradeIssueMapService {

	@Autowired
	private TradeIssueMapDao tradeIssueMapDao;
	
	public void createTradeIssueMap(TradeIssueMap tradeIssue) {
		tradeIssueMapDao.create(tradeIssue);
	}

	public void deleteTradeIssueMap(TradeIssueMap tradeIssue) {
		tradeIssueMapDao.delete(tradeIssue);
	}

	public void updateTradeIssueMap(TradeIssueMap tradeIssue) {
		tradeIssueMapDao.update(tradeIssue);
	}

	public void createTradeIssueMap(List<TradeIssueMap> list) {
		// TODO Auto-generated method stub
		tradeIssueMapDao.create(list);
	}

	public TradeIssueMap getByTradeIssueKey(TradeIssueMapKey tradeIssueMapKey) {
		return tradeIssueMapDao.getByTradeIssueKey(tradeIssueMapKey);
	}

	/** (non-Javadoc)
	 * @author LuanNgu
	 * @see lle.crud.service.TradeIssueMapService#insertTradeIssue(java.util.HashMap)
	 */
	@Override
	public void insertTradeIssue(HashMap<String, String> groups) {
		// TODO Auto-generated method stub
		tradeIssueMapDao.insertTradeIssue(groups);
	}
	

}
