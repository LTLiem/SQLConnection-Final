package lle.crud.service;

import java.util.List;
import lle.crud.model.Status;

public interface StatusService {

	public void createStatus(Status status);

	public void deleteStatus(Status status);

	public void updateStatus(Status status);

	public Status getStatusById(int id);

	public List<Status> getAllStatus();
}
