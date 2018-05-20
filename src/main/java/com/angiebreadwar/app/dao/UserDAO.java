package com.angiebreadwar.app.dao;

import java.util.List;

import com.angiebreadwar.app.model.User;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;

	
	public interface UserDAO {

		User findUser(int id) throws DAOException, EmptyResultException;

		void create(String name, int email, String password, int tipo) throws DAOException;

		void delete(int id) throws DAOException;

		void update(String name, int email, String password, int tipo) throws DAOException;

		User findEmployeeByEmail(int email) throws DAOException, EmptyResultException;

		List<User> findAllUsers() throws DAOException, EmptyResultException;

		List<User> findEmployeesByName(String name) throws DAOException, EmptyResultException;

		User validate(int email, String password) throws LoginException, DAOException;

	}


