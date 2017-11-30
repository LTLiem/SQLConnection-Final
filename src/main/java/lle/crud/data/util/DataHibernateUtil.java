/**
 * Created and updated by Liem Le
 */
package lle.crud.data.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import lle.crud.service.ActionService;
import lle.crud.service.IssueService;
import lle.crud.service.RoleService;
import lle.crud.service.StatusService;
import lle.crud.service.TradeHeaderService;
import lle.crud.service.TradeIssueMapService;
import lle.crud.service.TradeService;
import lle.crud.service.UserService;


public class DataHibernateUtil  {
	
	private static ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	
	public static IssueService getIssueService() {
		return context.getBean(IssueService.class);
	}
	
	public static TradeService getTradeService() {
		return context.getBean(TradeService.class);
	}
	
	public static TradeHeaderService getTradeHeaderService() {
		return context.getBean(TradeHeaderService.class);
	}
	
	public static TradeIssueMapService getTradeIssueMapService() {
		return context.getBean(TradeIssueMapService.class);
	}
	
	public static UserService getUserService() {
		return context.getBean(UserService.class);
	}
	
	public static RoleService getRoleService() {
		return context.getBean(RoleService.class);
	}
	
	public static StatusService getStatusService() {
		return context.getBean(StatusService.class);
	}
	
	public static ActionService getActionService() {
		return context.getBean(ActionService.class);
	}
}
