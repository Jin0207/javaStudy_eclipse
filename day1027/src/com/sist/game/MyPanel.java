package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;

public class MyPanel extends JPanel implements KeyListener{
	//여러개의 적을 만들기위해 ArrayList를 만듦
	ArrayList<Enermy> enermyList;
	SpaceShip spaceship;
	Missile missile;
	
	public MyPanel() {
		super();
		addKeyListener(this);
		requestFocus();
		setFocusable(true);

		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		
		//여러개의 "적"을 담기위한 ArrayList객체 생성
		enermyList = new ArrayList<Enermy>();
		
		//"적"을 5개 만듦
		for(int i = 1; i <= 5; i++) {
			enermyList.add(new Enermy("enermy.png"));
		}

		class MyThread extends Thread{
			
			public void run() {
				while(true) {
					//리스트에 담긴 "적"의 수만큼 반복하여 "적"의 위치 변경
					missile.update();
					
					for(Enermy e : enermyList) {
						e.update();
						e.crush(missile);
					}
					
					repaint();
					
					try {
						Thread.sleep(20);
					}catch (Exception e) {
					}//end try,catch
				}//end while
			}//end run()
		}//end MyThread
		
		Thread t = new MyThread();
		t.start();
	}// end MyPanel 생성자
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//여러개의 적이 담겨있는 리스트의 수만큼 반복하여 적을 다시 그려준다
			for(Enermy e : enermyList) {
				e.draw(g);
			}			
			spaceship.draw(g);
			missile.draw(g);
		}
		
		public void keyPressed(KeyEvent event) {
			spaceship.keyPressed(event);
			missile.keyPressed(event, spaceship.x,spaceship.y);
		}

		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	
}
