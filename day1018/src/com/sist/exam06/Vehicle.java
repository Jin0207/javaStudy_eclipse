package com.sist.exam06;

public abstract class Vehicle {
	protected int speed;
	//추상클래스는 추상메서드 이외에 일반속성을 포함할 수 있음
	public void printSpeed() {
		System.out.println("현재속도: " + speed);
	}
	//추상클래스는 추상메서드 이외에 구현부를가진 일반메서드를 포함할 수 있음.
	public abstract double getKilosPerLiter();

}
