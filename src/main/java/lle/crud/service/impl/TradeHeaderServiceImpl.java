package lle.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lle.crud.dao.TradeHeaderDao;
import lle.crud.model.TradeHeader;
import lle.crud.model.TradeHeaderKey;
import lle.crud.service.TradeHeaderService;

@Service("TradeHeaderService")
@Transactional
public class TradeHeaderServiceImpl implements TradeHeaderService {

	@Autowired
	private TradeHeaderDao trnHdrDao;
	
	public void createTradeHeader(TradeHeader tradeHeader) {
		trnHdrDao.create(tradeHeader);
	}

	public void deleteTradeHeader(TradeHeader tradeHeader) {
		trnHdrDao.delete(tradeHeader);
	}

	public void updateTradeHeader(TradeHeader tradeHeader) {
		trnHdrDao.update(tradeHeader);
	}

	public List<TradeHeader> getAllTradeHeader() {
		return trnHdrDao.getAll();
	}

	public TradeHeader getTradeHeaderByFGT(TradeHeaderKey key) {
		return trnHdrDao.getIssueByFGT(key);
	}

}
