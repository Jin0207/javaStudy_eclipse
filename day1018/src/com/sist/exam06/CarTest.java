package com.sist.exam06;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vehicle vc = new Vehicle();
		//추상메서드를 가진 추상클래스의 객체를 생성할 수 없음
		
		Car car = new Car();
		System.out.println(car.getKilosPerLiter());
		car.printSpeed();
		//추상클래스인 Vehicle 클래스의 객체는 생성할 수 없지만
		//그것을 구현한 Car클래스의 객체를 생성할 수 있어요
	}

}
