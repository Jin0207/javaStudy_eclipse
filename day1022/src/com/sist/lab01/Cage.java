package com.sist.lab01;

import java.util.ArrayList;

abstract class Animal{
	public abstract void move();
}

class Lion extends Animal{
	public void move() {
		System.out.println("사자가 움직입니다.");
	}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("호랑이가 움직입니다.");
	}
}

public class Cage {
	ArrayList<Animal> list = new ArrayList<Animal>();
	//Animal 과 is a 관계에 있는 클래스객체들을 담을 수있음
	
	public static void main(String[] args) {
		Cage cage = new Cage();
		cage.list.add(new Lion());
		cage.list.add(new Tiger());
		
		for(Animal animal : cage.list) {
			animal.move();
		}
	}

}
