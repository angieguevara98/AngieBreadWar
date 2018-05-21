package com.angiebreadwar.app.model;

public class User {
	
	int id;
	String name;
	int codigo;
	String password;
	int tipo;
	String email;
	
	
	public User(String name, int codigo, String password, int tipo, String email) {
		super();
		this.name = name;
		this.codigo = codigo;
		this.password = password;
		this.tipo = tipo;
		this.email = email;
		
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email= email;
	}
	
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", codigo=" + codigo + ", password="
				+ password + " , tipo=" + tipo +", email" + email +"]";
	}


}
