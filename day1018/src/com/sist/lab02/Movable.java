package com.sist.lab02;

public interface Movable {
	//final static int speed = 100;
	int speed = 100;
	
	/*
	 * The blank final field speed may not have been initialized
	 */
	//public abstract void speedUp(int amount);
	//public abstract void speedDouwn(int amount);
	public void speedUp(int amount);
	public void speedDouwn(int amount);
	public void printSpeed(); 
	/*{
		System.out.println(speed);
	}
	/*
	 * Abstract methods do not specify a body
	 * �������̽����� body�� ��üȭ�� �޼��带 ������ �� ����
	 */
}
