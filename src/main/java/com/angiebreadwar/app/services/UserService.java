package com.angiebreadwar.app.services;

import java.util.List;

import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.EmptyResultException;
import com.angiebreadwar.app.model.User;



public interface UserService {
	
	User find(int id) throws DAOException, EmptyResultException;

	List<User> findAll() throws DAOException, EmptyResultException;

	void update(int codigo, String email, String password, String name, int tipo)
			throws DAOException;

}
