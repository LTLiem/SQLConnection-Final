package lle.crud.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lle.crud.dao.ActionDao;
import lle.crud.model.Action;
import lle.crud.service.ActionService;

@Service("ActionService")
@Transactional
public class ActionServiceImpl implements ActionService {
	
	@Autowired
	private ActionDao actionDao;

	public void createAction(Action action) {
		actionDao.create(action);
	}

	public void deleteAction(Action action) {
		actionDao.delete(action);
	}

	public void updateAction(Action action) {
		actionDao.update(action);
	}

	public List<Action> getAllAction() {
		return actionDao.getAll();
	}

	public Action getActionById(int id) {		
		return actionDao.get(id);
	}

}
