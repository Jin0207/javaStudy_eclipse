package com.sist.game;

import java.awt.event.KeyEvent;

public class SpaceShip extends GraphicObject {
	
	public SpaceShip(String name) {
		super(name);
		x = 150;
		y = 350;
	}
	
	public void keyPressed(KeyEvent event) {
		
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 20;
		}
		
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 20;
		}
		
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 20;
		}
		
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 20;
		}
		
		
	}
}
