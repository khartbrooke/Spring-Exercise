package com.example.demo.domain;

public class Game {
	Integer id;
    Double price;
    String name;  
    
    
	public Game() {
		super();
	}
	public Game(Integer id, Double price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", price=" + price + ", name=" + name + "]";
	}
    
    
}
