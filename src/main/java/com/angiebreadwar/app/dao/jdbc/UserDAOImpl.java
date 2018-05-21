package com.angiebreadwar.app.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.angiebreadwar.app.dao.UserDAO;
import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.EmptyResultException;
import com.angiebreadwar.app.exception.LoginException;
import com.angiebreadwar.app.mapper.UserMapper;
import com.angiebreadwar.app.model.User;


@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User findUser(int id) throws DAOException, EmptyResultException {
		String query = "SELECT id, codigo, password, name, codigo, tipo"
				+ " FROM usuarios WHERE id = ?";

		Object[] params = new Object[] { id };

		try {

			User user = (User) jdbcTemplate.queryForObject(query, params, new UserMapper());
			//
			return user;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(String name, int codigo, String password, int tipo, String email) throws DAOException {
		String query = "INSERT INTO employees (codigo, password, name, email, tipo)  VALUES ( ?,?,?,?,?,? )";

		Object[] params = new Object[] { codigo, password, name, email, tipo };

		User user = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			user = this.findUserByEmail(email);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}


	@Override
	public void delete(int id) throws DAOException {
		String query = "DELETE FROM  usuarios WHERE id = ? ";

		Object[] params = new Object[] { id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

		

	@Override
	public void update(String name, int codigo, String password, int tipo, String email) throws DAOException {
		String query = "UPDATE usuarios SET password = ?, name =?, codigo = ?, email = ?, tipo = ? WHERE id = ?";

		Object[] params = new Object[] { password, name, codigo, email, tipo};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
		
	}

	@Override
	public User findUserByEmail(String email) throws DAOException, EmptyResultException {
		String query = "SELECT id, codigo, password, name, email, tipo"
				+ " FROM employees WHERE login = ? ";

		Object[] params = new Object[] { email };

		try {

			User user = jdbcTemplate.queryForObject(query, params, new UserMapper());
			//
			return user;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<User> findAllUsers() throws DAOException, EmptyResultException {
		String query = "SELECT id, codigo, password, name, email, tipo FROM usuarios ";

		try {

			List<User> employees = jdbcTemplate.query(query, new UserMapper());
			//
			return employees;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<User> findUsersByName(String name) throws DAOException, EmptyResultException {
		String query = "SELECT id, codigo, password, name, email, tipo"
				+ " FROM usuarios WHERE upper(name) like upper(?) ";

		Object[] params = new Object[] { "%" + name + "%" };

		try {

			List<User> employees = jdbcTemplate.query(query, params, new UserMapper());
			//
			return employees;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public User validate(int codigo, String password) throws LoginException, DAOException {
		logger.info("validate(): codigo: " + codigo + ", password: " + password);
		
		if ("".equals(codigo) && "".equals(password)) {
			throw new LoginException("Codigo o password incorrecto");
		}
	
		String query = "SELECT codigo, password, id, name, email, tipo"
				+ " FROM usuarios WHERE codigo=? AND password=?";
	
		Object[] params = new Object[] { codigo, password };
	
		try {
	
			User user = (User) jdbcTemplate.queryForObject(query, params, new UserMapper());
			//
			return user;
	
		} catch (EmptyResultDataAccessException e) {
			logger.info("Employee y/o clave incorrecto");
			throw new LoginException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	}
	
	

