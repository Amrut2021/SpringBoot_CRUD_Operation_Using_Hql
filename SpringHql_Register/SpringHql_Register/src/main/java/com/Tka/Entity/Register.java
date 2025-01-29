package com.Tka.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String city;
	private String gender;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlNmae() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Register(int id, String fName, String lNmae, String email, String password, String city, String gender,
			int age) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lNmae;
		this.email = email;
		this.password = password;
		this.city = city;
		this.gender = gender;
		this.age = age;
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", city=" + city + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	

}
