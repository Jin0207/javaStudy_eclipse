package com.sist.lab02;

public abstract class Vehicle {
	private int speed;
	//������
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
	
	//�߻�Ŭ������ �߻�޼��� �̿ܿ� �ϹݼӼ��� ������ �� ����
	public void printSpeed() {
		System.out.println("����ӵ�: " + speed);
	}
	//�߻�Ŭ������ �߻�޼��� �̿ܿ� �����θ����� �Ϲݸ޼��带 ������ �� ����.
	public abstract double getKilosPerLiter();

}
