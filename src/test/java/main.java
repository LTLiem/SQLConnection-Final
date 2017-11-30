import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		//ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		
		//System.out.println(context.getBeanDefinitionNames().getClass());
		//Object obj = context.getBean("issueService");
		//IssueService issueService = context.getBean(IssueService.class);
		//TradeService tradeService = context.getBean(TradeService.class);
		//TradeHeaderService tradeHeaderService = context.getBean(TradeHeaderService.class);
		
		//System.out.println(tradeService.getClass());
		//System.out.println(issueService.getClass());
		//System.out.println(tradeHeaderService.getClass());
		
		//PASSED
		//TradeHeaderKey key = new TradeHeaderKey("CURR","FXD","FXD");
		//TradeHeader tradeHeader = tradeHeaderService.getTradeHeaderByFGT(key);
		//System.out.println(tradeHeader.getDescription());
		//System.out.println(tradeHeader.getTradeList().get(0).getTradeNb());
		
		//List<TradeHeader> headers = tradeHeaderService.getAllTradeHeader();
		//System.out.println(headers.size());
		
		//List<Trade> trades = tradeService.getAllTrade();
		//System.out.println(trades.get(0).getTradeHeader().getDescription());
		
		//Issue issue = issueService.getIssueById(1);
		//System.out.println(issue.getTradeList().get(0).getTradeNb());
		
//		UserService uss = DataHibernateUtil.getUserService();
//		User user = uss.getUserByName("LLE");
//		System.out.println(user.getPwd());
		
		IssueService uss = DataHibernateUtil.getIssueService();
		ActionService ass = DataHibernateUtil.getActionService();
		
		Issue issue = uss.getIssueById(1);
		System.out.println(issue.getLastActionId());
		System.out.println(ass.getActionById(issue.getLastActionId()).getAction());
		
		/*TradeIssueMapService  tradeIssueMapService = DataHibernateUtil.getTradeIssueMapService();
		
		TradeIssueMapKey key = new TradeIssueMapKey("12345", 3);
		Date date = new Date();
		
		TradeIssueMap tradeIssueMap = new TradeIssueMap(key, date);
		tradeIssueMapService.createTradeIssueMap(tradeIssueMap);*/

	}

}
