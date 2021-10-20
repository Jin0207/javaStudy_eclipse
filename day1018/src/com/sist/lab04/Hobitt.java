package com.sist.lab04;

public class Hobitt extends GameCharacter {
	
	public Hobitt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getRing() {
		System.out.println("GameCharacter()의 getRing()");
	}

	@Override
	public void draw() {
		System.out.println("호빗을 그립니다.");
	}
}
