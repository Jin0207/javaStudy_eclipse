package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
			int dx;
			int dy;
			
	public Enermy(String name) {
		super(name);
		Random r = new Random();
		
		x = r.nextInt(500);
		y = r.nextInt(300);
		
		dx = r.nextInt() % 30;
		dy = r.nextInt() % 30;
		
		if(dx >= 0) x += 10; 
		else dx -= 10;
		
		if(dy >= 0) y += 10;
		else dy -= 10;
		
		System.out.println("dx: " + dx);
		System.out.println("dy: " + dy);
	}
	
	public void update() {		
		x += dx;
		y += dy;
		
		if(x < 0 || x > 500) {
			dx = dx * -1;
		}
	
		if(y < 0 || y > 500) {
			dy = dy * -1;
		}
	}
	
	public void crush( Missile missile ){
		if(x <= missile.x && missile.x <= x + 100 && y <= missile.y && missile.y <= y + 90) {
			File file = new File("EXPLODE.WAV");
			
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(file));
				clip.start();
			}catch (Exception e) {
			}
			
			y = -1000;
		}
	}
	
}
