package com.angiebreadwar.app.model;

public class User {
	
	int id;
	String name;
	int email;
	String password;
	int tipo;
	
	
	public User(String name, int email, String password, int tipo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
		
	}

	public User() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmail() {
		return email;
	}
	public void setEmail(int email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
		
	}
	
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password="
				+ password + " , tipo=" + tipo +"]";
	}


}
