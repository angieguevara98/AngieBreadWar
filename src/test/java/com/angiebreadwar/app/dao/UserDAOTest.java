package com.angiebreadwar.app.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.EmptyResultException;
import com.angiebreadwar.app.model.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class UserDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

	@Autowired
	private UserDAO userDAO;

	
	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	@Test
	public void testFindUserById() {

		try {
			//
			User user = userDAO.findUser(1);

			Assert.assertNotNull(user);

			Assert.assertEquals("107908", user.getCodigo());
			Assert.assertEquals("123", user.getPassword());
			Assert.assertEquals("Angie", user.getName());
			Assert.assertEquals("angie.guevara@tecsup.edu.pe", user.getEmail());
			Assert.assertEquals(1, user.getTipo());

			logger.info(user.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testFindAllUsers() {

		try {
			//
			List<User> users = userDAO.findAllUsers();

			//Assert.assertEquals(emps.size(), 4);

			logger.info(users.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

		
	}

	@Test
	public void testFindUserByEmail() {

		try {
			//
			User user = userDAO.findUserByEmail("angie.guevara@tecsup.edu.pe");
			// @formatter:on


			Assert.assertEquals("123", user.getPassword());
			Assert.assertEquals("Angie", user.getName());
			Assert.assertEquals("107908", user.getCodigo());
			Assert.assertEquals(1, user.getTipo());

			logger.info(user.toString());
			
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testCreateUser() {

		logger.info("--");
		
		String email = "sebastian.rau@tecsup.edu.pe" + (int) (Math.random() * 100);
		//logger.info(LOGIN);
		String password = "123";
		String name = "Sebastian";
		int codigo = 107908;
		int tipo = 2;

		try {
			//
			userDAO.create(name, codigo, password, tipo, email);

			//
			User user = userDAO.findUserByEmail(email);

			Assert.assertEquals(password, user.getPassword());
			Assert.assertEquals(name, user.getName());
			Assert.assertEquals(email, user.getEmail());
			Assert.assertEquals(tipo, user.getTipo());

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}

	
	
	@Test
	public void testUpdateUser() {

		int codigo = 107908 + (int)(Math.random() * 100);
		String password = "123";
		String name = "Angie";
		String email = "angie.guevara@tecsup.edu.pe";
		int tipo = 1;
		
		int UP_CODIGO = 710908;
		String UP_PWD = "456";
		String UP_NAME = "Angie1";
		String UP_EMAIL = "angi@tecsup.edu.pe";
		int UP_TIPO = 1;
		
		try {
			//
			userDAO.create(password, codigo, name, tipo, email);
			//
			userDAO.update(UP_NAME, UP_CODIGO, UP_PWD, UP_TIPO, UP_EMAIL);
			//
			User user = userDAO.findUserByEmail(email);

			Assert.assertEquals(UP_PWD, user.getPassword());
			Assert.assertEquals(UP_NAME, user.getName());
			Assert.assertEquals(UP_EMAIL, user.getEmail());
			Assert.assertEquals(UP_TIPO, user.getTipo());

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}
	
	
	@Test
	public void testDeleteUser() {
		
		int id = 2;
		int codigo = 107908;
		String password = "123";
		String name = "Juan";
		String email = "angie.guevaraqtecsup.edu.pe";
		int tipo = 1;

		try {
			//
			userDAO.create(name, codigo, password, tipo, email);

		} catch (DAOException e) {
			fail(e.getMessage());
		}

		try {

			userDAO.delete(id);

			userDAO.findUserByEmail(email);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// Usuario borrado 
			return;
		}

	}
	
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
}
