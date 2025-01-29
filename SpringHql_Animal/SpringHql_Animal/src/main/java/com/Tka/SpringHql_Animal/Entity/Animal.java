package com.Tka.SpringHql_Animal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String color;
	private int age;
	private int weight;
	
	
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", color=" + color + ", age=" + age + ", weight=" + weight + "]";
	}
	public Animal(int id, String name, String color, int age, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.age = age;
		this.weight = weight;
	}
	public Animal() {
		super();
	}
	
	
	

}
