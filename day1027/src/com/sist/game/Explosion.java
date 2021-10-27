package com.sist.game;

public class Explosion extends GraphicObject {
	
	public Explosion(String name) {
		super(name);
		
		x = -150;
		y = 0;
	}
	
	public void update(int x) {
		this.x = x;
		try {
			Thread.sleep(100);
			this.x = -150;
		}catch (Exception e) {
		}
	}
}
