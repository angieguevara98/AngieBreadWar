package com.angiebreadwar.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.EmptyResultException;
import com.angiebreadwar.app.model.User;
import com.angiebreadwar.app.dao.UserDAO;


public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User find(int id) throws DAOException, EmptyResultException {
		User user = userDAO.findUser(id);

		return user;
	}

	@Override
	public List<User> findAll() throws DAOException, EmptyResultException {
		List<User> user = userDAO.findAllUsers();

		return user;
	}

	@Override
	public void update(int codigo, String email, String password, String name, int tipo) throws DAOException {
		
		userDAO.update(name, codigo, password, tipo, email);
		
	}

}
