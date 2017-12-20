import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import lle.crud.data.util.DataHibernateUtil;
import lle.crud.model.Issue;
import lle.crud.model.Trade;
import lle.crud.model.TradeHeader;
import lle.crud.model.TradeHeaderKey;
import lle.crud.model.TradeIssueMap;
import lle.crud.model.TradeIssueMapKey;
import lle.crud.model.User;
import lle.crud.service.ActionService;
import lle.crud.service.IssueService;
import lle.crud.service.TradeService;
import lle.crud.service.UserService;
import lle.crud.service.TradeHeaderService;
import lle.crud.service.TradeIssueMapService;


public class main {

	public static void main(String[] args) {
		
		TradeIssueMapService service = DataHibernateUtil.getTradeIssueMapService();
		
		List<TradeIssueMap> result = service.getByCreatedUserId(2);
		
		System.out.println(result.size());

/*		TradeIssueMapService  tradeIssueMapService = DataHibernateUtil.getTradeIssueMapService();

		
		TradeIssueMapKey key = new TradeIssueMapKey("12345", 1);
		//Date date = new Date();
		
		//TradeIssueMap tradeIssueMap = new TradeIssueMap(key, date);
		TradeIssueMap tm = tradeIssueMapService.getByTradeIssueKey(key);
		
		if(tm != null) {
			System.out.println(tm.getInputDate());
		} else {
			System.out.println("Connection is not exists");
		}	*/
		
		/*TradeService tradeService = DataHibernateUtil.getTradeService();
		List<Trade> trades = tradeService.getTradeByCriteria(null);
		System.out.println(String.join(",", trades.stream().map(t->t.getTradeNb()).collect(Collectors.toList())));*/

	}

}
