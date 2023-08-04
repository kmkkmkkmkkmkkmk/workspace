package edu.kh.poly.model.dto;

public class Car extends Object{
				// extends Object : 미 작성 시 컴파일러가 자동 추가
	
	private int whell; // 바퀴 개수
	private int seat;  // 좌석 수
	private String fuel; // 연료
	
	
	// 기본 생성자 자동 완성 : ctrl + space bar -> enter 
	public Car() {
		
	}


	// 매개변수 생성자 자동 완성 : alt + shift + s  ->  o
	public Car(int whell, int seat, String fuel) {
		super();
		this.whell = whell;
		this.seat = seat;
		this.fuel = fuel;
	}


	// getter / setter 자동 완성 : alt + shift + s  ->  r 
	public int getWhell() {
		return whell;
	}


	public void setWhell(int whell) {
		this.whell = whell;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	public String getFuel() {
		return fuel;
	}


	public void setFuel(String fuel) {
		this.fuel = fuel;
	}


	// Object toString() 오버라이딩 자동 완성 
	// alt + shift + s  ->  s
	@Override
	public String toString() {
		return "Car [whell=" + whell + ", seat=" + seat + ", fuel=" + fuel + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
