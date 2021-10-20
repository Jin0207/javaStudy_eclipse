package com.sist.lab02;

public abstract class Vehicle {
	private int speed;
	//생성자
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(int speed) {
		super();
		this.speed = speed;
	}
	//getter, setter
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//추상클래스는 추상메서드 이외에 일반속성을 포함할 수 있음
	public void printSpeed() {
		System.out.println("현재속도: " + speed);
	}
	//추상클래스는 추상메서드 이외에 구현부를가진 일반메서드를 포함할 수 있음.
	public abstract double getKilosPerLiter();

}
