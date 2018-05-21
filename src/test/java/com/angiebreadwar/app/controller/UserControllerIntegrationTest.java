package com.angiebreadwar.app.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class UserControllerIntegrationTest {

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
	@WebAppConfiguration
	public class EmployeeControllerIntegrationTest {

		@Autowired
		private WebApplicationContext wac;

		private MockMvc mockMvc;
		
		@Before
		public void setup() throws Exception {
		    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		}
		
		@Test
		public void givenWac_whenServletContext_thenItProvidesGreetController() {
		    ServletContext servletContext = wac.getServletContext();
		     
		    Assert.assertNotNull(servletContext);
		    Assert.assertTrue(servletContext instanceof MockServletContext);
		    Assert.assertNotNull(wac.getBean("userController"));
		}
		
		
		@Test
		public void list() throws Exception {
			mockMvc.perform(get("/admin/emp/list"))
					.andExpect(status().isOk())
					.andExpect(view().name("admin/emp/list"))
					.andExpect(forwardedUrl("/WEB-INF/views/admin/emp/list.jsp"))
					//.andExpect(model().attribute("usuarios", hasSize(43)))
					.andExpect(model().attribute("usuarios",
							hasItem(allOf(  
											hasProperty("Id", is(1)),
											hasProperty("codigo", is("107908")),
											hasProperty("password", is("123456")),
											hasProperty("name", is("Angie")),
											hasProperty("email", is("angie.guevara@tecsup.edu.pe")), 
											hasProperty("tipo", is(1)) 
										))));
		}
	}
}
		
	