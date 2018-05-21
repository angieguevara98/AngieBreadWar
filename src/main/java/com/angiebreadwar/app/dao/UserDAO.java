package com.angiebreadwar.app.dao;

import java.util.List;

import com.angiebreadwar.app.model.User;
import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.EmptyResultException;
import com.angiebreadwar.app.exception.LoginException;

	
	public interface UserDAO {

		User findUser(int id) throws DAOException, EmptyResultException;


		void delete(int id) throws DAOException;

		User findUserByEmail(String email) throws DAOException, EmptyResultException;

		List<User> findAllUsers() throws DAOException, EmptyResultException;

		List<User> findUsersByName(String name) throws DAOException, EmptyResultException;

		User validate(int codigo, String password) throws LoginException, DAOException;

		void update(String name, int codigo, String password, int tipo, String email) throws DAOException;

		void create(String name, int codigo, String password, int tipo, String email) throws DAOException;

	}


