package edu.kh.test;

public class Fruit {
	private String name; // 과일명
	private int price; // 가격
	private int amount; // 개수
	
	public Fruit() {}

	public Fruit(String name, int price, int amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}

