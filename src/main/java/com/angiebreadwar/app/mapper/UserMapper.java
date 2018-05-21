package com.angiebreadwar.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.angiebreadwar.app.model.User;


public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setCodigo(rs.getInt("codigo"));
		user.setPassword(rs.getString("password"));
		user.setTipo(rs.getInt("tipo"));
		user.setId(rs.getInt("id"));
		
		return user;
	}
}
