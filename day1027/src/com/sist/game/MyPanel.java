package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;

public class MyPanel extends JPanel implements KeyListener{
	//�������� ���� ��������� ArrayList�� ����
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
		
		//�������� "��"�� ������� ArrayList��ü ����
		enermyList = new ArrayList<Enermy>();
		
		//"��"�� 5�� ����
		for(int i = 1; i <= 5; i++) {
			enermyList.add(new Enermy("enermy.png"));
		}

		class MyThread extends Thread{
			
			public void run() {
				while(true) {
					//����Ʈ�� ��� "��"�� ����ŭ �ݺ��Ͽ� "��"�� ��ġ ����
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
	}// end MyPanel ������
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//�������� ���� ����ִ� ����Ʈ�� ����ŭ �ݺ��Ͽ� ���� �ٽ� �׷��ش�
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
