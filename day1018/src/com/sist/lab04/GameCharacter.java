package com.sist.lab04;

public abstract class GameCharacter {
	//������
	public GameCharacter() {
		super();
		// TODO Auto-generated constructor stub
	}
	//getter setter
	public abstract void draw();
	
	public void getLife() {
		System.out.println("GameCharacter()�� getLife()");
	}

}
