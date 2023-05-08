package com.example.springdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DemoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String dept;
	private String email;
	@Column(unique = true)
	private String uname;
	private String pwd;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="NewEntity_id")
	private NewEntity new_entity;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public NewEntity getNew_entity() {
		return new_entity;
	}
	public void setNew_entity(NewEntity new_entity) {
		this.new_entity = new_entity;
	}
	public DemoEntity()
	{
		super();
	}
	@Override
	public String toString() {
		return "DemoEntity [id=" + id + ", name=" + name + ", dept=" + dept + ", email=" + email + ", uname=" + uname
				+ ", pwd=" + pwd + ", new_entity=" + new_entity + "]";
	}
	
}


