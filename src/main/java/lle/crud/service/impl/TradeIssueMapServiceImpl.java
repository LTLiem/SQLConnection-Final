package lle.crud.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lle.crud.dao.TradeIssueMapDao;
import lle.crud.model.TradeIssueMap;
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
	

}
