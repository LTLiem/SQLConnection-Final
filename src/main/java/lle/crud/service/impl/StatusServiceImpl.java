package lle.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lle.crud.dao.StatusDao;
import lle.crud.model.Status;
import lle.crud.service.StatusService;

@Service("StatusService")
@Transactional
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusDao statusDao;

	public void createStatus(Status status) {
		statusDao.create(status);		
	}

	public void deleteStatus(Status status) {
		statusDao.delete(status);
	}

	public void updateStatus(Status status) {
		statusDao.update(status);
	}

	public List<Status> getAllStatus() {
		return statusDao.getAll();
	}

	public Status getStatusById(int id) {		
		return statusDao.get(id);
	}
}
