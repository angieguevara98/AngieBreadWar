package com.angiebreadwar.app.dao.jdbc;

import java.util.List;

import com.angiebreadwar.app.dao.UserDAO;
import com.angiebreadwar.app.model.User;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;

public class UserDAOImpl implements UserDAO{

	@Override
	public User findUser(int id) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(String name, int email, String password, int tipo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String name, int email, String password, int tipo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findEmployeeByEmail(int email) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findEmployeesByName(String name) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validate(int email, String password) throws LoginException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
