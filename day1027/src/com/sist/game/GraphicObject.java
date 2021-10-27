package com.sist.game;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GraphicObject {
	
	BufferedImage img = null;
	int x = 0, y = 0;

	public GraphicObject(String name) {
		try {
			img = ImageIO.read(new File(name));
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		
	}

	public void update() {}
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null);
	}

	public void keyPressed(KeyEvent event) {}
}
