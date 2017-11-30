package lle.crud.dao.impl;

import org.springframework.stereotype.Repository;
import lle.crud.dao.StatusDao;
import lle.crud.model.Status;

@Repository
public class HbnStatusDao extends AbstractHbnDao<Status> implements StatusDao {

}
