package com.sist.lab02;

public class Car extends Vehicle implements Movable{
	private String name;
	private String color;
	//생성자
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
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
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

	@Override
	public void speedUp(int amount) {
		System.out.println(amount + "만큼 속도를 올립니다.");		
	}

	@Override
	public void speedDouwn(int amount) {
		System.out.println(amount + "만큼 속도를 줄입니다.");		
	}

	@Override
	public void printSpeed() {
		System.out.println(speed);
	}
	
	public void turnLeft() {
		System.out.println("좌회전 합니다");
	}
	
	public void turnRight() {
		System.out.println("우회전 합니다.");
	}

	@Override
	public double getKilosPerLiter() {
		return 300;
	}
	
}
