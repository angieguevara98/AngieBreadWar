package com.angiebreadwar.app.services;

import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.LoginException;
import com.angiebreadwar.app.model.User;

public interface SecurityService {
	
	User validate(int codigo, String password) throws LoginException, DAOException;

}
