package com.sist.lab02;

public class CarTest {

	public static void main(String[] args) {
		Car c = new Car("K5", "���");
		c.speedDouwn(104);
		c.speedUp(150);
		c.printSpeed();
		
		Movable m = new Car();
		//�������̽��� Ŭ������ ���������� �ڷ����� ����
		//�������̽� �� �������̽��� ������ Ŭ���� ���̿��� Ŭ������ ���������� ��Ӱ��迡 ����
		//���� ���� �������̽��� ���������� �ڽ�Ŭ������ ��ü�� ������ �� ����
		
		m.speedUp(50);
		m.speedDouwn(10);
		//��Ӱ��迡 ���� ��, �θ��� ���������� �ڽ�Ŭ������ ��ü�� ������ ��
		//�θ�Ŭ�������� �ִ� �޼��带 ȣ���� �� �ִµ�,
		//ȣ��� �޼���� �ڽ�Ŭ�������� �������̵� �� �޼��尡 ȣ��ȴ�.
		
		((Car)m).turnLeft();
		((Car)m).turnRight();
		//�θ�Ŭ������ ���� �����������ʴ� �޼���� ȣ���� �� ����
		//�ڽ�Ŭ���� �ڷ������� ����ȯ���شٸ� �����ϴ�. (�����ϰ� �ִ� ��ü�� �ڽ�Ŭ������ü�̹Ƿ�)
		
		//Car c = m;
		c = (Car)m;
		//��۰��迡 �ִ� �θ��� ������������ �ڽ�Ŭ������ ��ü�� �����ϰ� �ִ°��
		//�ش� �ڽ�Ŭ������ ������ ��ȯ�Ͽ� �ڽ�Ŭ������ ���������� ������ �� �ִ�.
		
		c.turnLeft();
		c = new Car();
		c.turnLeft();
		m = c;
		((Car)m).turnLeft();
		Car c2 = new Car();
		Movable m2 = c2;

	}

}