package lle.crud.service;

import java.util.List;
import lle.crud.model.Action;

public interface ActionService {

	public void createAction(Action action);

	public void deleteAction(Action action);

	public void updateAction(Action action);
	
	public Action getActionById(int id);

	public List<Action> getAllAction();
}
