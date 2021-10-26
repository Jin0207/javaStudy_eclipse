package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Random;
import java.awt.Graphics;

public class MyPanel extends JPanel implements KeyListener{
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	Explosion explosion;
	
	public MyPanel() {
		super();
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		
		enermy = new Enermy("enermy.png");
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		explosion = new Explosion("explosion.png");
	
		class MyThread extends Thread{
			
			public void run() {
				while(true) {
					Random r = new Random();
					enermy.update();
					spaceship.update();
					missile.update();
					repaint();
					//enermy.randomLocation();
					if(enermy.x == missile.x) {
						explosion.update(enermy.x);
						enermy.x = -150;
						missile.x = -150;
					}
					try {
						Thread.sleep(40);
					}catch (Exception e) {
					}
				}
				
				
			}
		}
		Thread t = new MyThread();
		t.start();
	}
		
		public void paint(Graphics g) {
			super.paint(g);
			enermy.draw(g);
			spaceship.draw(g);
			missile.draw(g);
			explosion.draw(g);
		}
		
		public void keyPressed(KeyEvent event) {
			spaceship.keyPressed(event);
			missile.keyPressed(event, spaceship.x,spaceship.y);
		}

		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	
}
