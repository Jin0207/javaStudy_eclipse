package com.sist.lab01;

import java.util.ArrayList;

abstract class Animal{
	public abstract void move();
}

class Lion extends Animal{
	public void move() {
		System.out.println("���ڰ� �����Դϴ�.");
	}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("ȣ���̰� �����Դϴ�.");
	}
}

public class Cage {
	ArrayList<Animal> list = new ArrayList<Animal>();
	//Animal �� is a ���迡 �ִ� Ŭ������ü���� ���� ������
	
	public static void main(String[] args) {
		Cage cage = new Cage();
		cage.list.add(new Lion());
		cage.list.add(new Tiger());
		
		for(Animal animal : cage.list) {
			animal.move();
		}
	}

}
