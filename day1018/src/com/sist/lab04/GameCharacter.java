package com.sist.lab04;

public abstract class GameCharacter {
	//생성자
	public GameCharacter() {
		super();
		// TODO Auto-generated constructor stub
	}
	//getter setter
	public abstract void draw();
	
	public void getLife() {
		System.out.println("GameCharacter()의 getLife()");
	}

}
