package com.sist.game;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Missile extends GraphicObject {

	boolean launched = false;
	
	public Missile(String name) {
		super(name);
		y = -150;
	}
	
	public void update() {
		if(launched) {
			y -= 30;
		}
		
		if(y < -100) {
			launched = false;
			y = -150;
			x = -1000;
		}
				
	}

	public void keyPressed(KeyEvent event, int x, int y) {
		
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;
			File file = new File("LASER.WAV");
			
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(file));
				clip.start();
			}catch (Exception e) {
			}
			
			this.x = x;
			this.y = y;
		}
	}
}
