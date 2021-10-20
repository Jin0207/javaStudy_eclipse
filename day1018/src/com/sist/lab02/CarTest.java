package com.sist.lab02;

public class CarTest {

	public static void main(String[] args) {
		Car c = new Car("K5", "흰색");
		c.speedDouwn(104);
		c.speedUp(150);
		c.printSpeed();
		
		Movable m = new Car();
		//인터페이스도 클래스와 마찬가지로 자료형의 개념
		//인터페이스 와 인터페이스를 구현한 클래스 사이에는 클래스와 마찬가지로 상속관계에 있음
		//따라서 상위 인터페이스의 참조변수가 자식클래스의 객체를 참조할 수 있음
		
		m.speedUp(50);
		m.speedDouwn(10);
		//상속관계에 있을 때, 부모의 참조변수가 자식클래스의 객체를 참조할 때
		//부모클래스에게 있는 메서드를 호출할 수 있는데,
		//호출된 메서드는 자식클래스에서 오버라이딩 한 메서드가 호출된다.
		
		((Car)m).turnLeft();
		((Car)m).turnRight();
		//부모클래스가 본래 가지고있지않던 메서드는 호출할 수 없고
		//자식클래스 자료형으로 형변환해준다면 가능하다. (참조하고 있는 객체가 자식클래스객체이므로)
		
		//Car c = m;
		c = (Car)m;
		//상송관계에 있는 부모으 ㅣ참조변수가 자식클래스의 객체를 참조하고 있는경우
		//해당 자식클래스의 형으로 변환하여 자식클래스의 참조변수에 대입할 수 있다.
		
		c.turnLeft();
		c = new Car();
		c.turnLeft();
		m = c;
		((Car)m).turnLeft();
		Car c2 = new Car();
		Movable m2 = c2;

	}

}
