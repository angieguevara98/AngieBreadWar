package com.angiebreadwar.app.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.angiebreadwar.app.dao.UserDAO;
import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.LoginException;
import com.angiebreadwar.app.model.User;


public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User validate(int codigo, String password) throws LoginException, DAOException {
		User user = userDAO.validate(codigo, password);

		return user;
	}

}
