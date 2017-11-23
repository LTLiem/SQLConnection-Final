package lle.crud.dao.impl;

import org.springframework.stereotype.Repository;

import lle.crud.dao.TradeHeaderDao;
import lle.crud.model.TradeHeader;
import lle.crud.model.TradeHeaderKey;

@Repository
public class HbnTradeHeaderDao extends AbstractHbnDao<TradeHeader> implements TradeHeaderDao {

	public TradeHeader getIssueByFGT(TradeHeaderKey key) {
		TradeHeader trnHdr = null;
		
		trnHdr = (TradeHeader)getSession()
				.createQuery("from TradeHeader where tradeHeaderKey.trnFmly = :trnFmly "
						+ "and tradeHeaderKey.trnGrp = :trnGrp and tradeHeaderKey.trnType = :trnType")
				.setParameter("trnFmly", key.getTrnFmly())
				.setParameter("trnGrp", key.getTrnGrp())
				.setParameter("trnType", key.getTrnType())
				.uniqueResult();

		return trnHdr;
	}
}
