package com.sist.exam06;

public abstract class Vehicle {
	protected int speed;
	//�߻�Ŭ������ �߻�޼��� �̿ܿ� �ϹݼӼ��� ������ �� ����
	public void printSpeed() {
		System.out.println("����ӵ�: " + speed);
	}
	//�߻�Ŭ������ �߻�޼��� �̿ܿ� �����θ����� �Ϲݸ޼��带 ������ �� ����.
	public abstract double getKilosPerLiter();

}
