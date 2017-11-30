package lle.crud.dao.impl;

import org.springframework.stereotype.Repository;

import lle.crud.dao.ActionDao;
import lle.crud.model.Action;

@Repository
public class HbnActionDao extends AbstractHbnDao<Action> implements ActionDao {

}
