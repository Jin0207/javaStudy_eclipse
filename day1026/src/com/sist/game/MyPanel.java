package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Random;
import java.awt.Graphics;
// ��, �̻���, ���ּ� �� ���ÿ�(�Ѳ�����) ���� �� �ִ� "�г�"Ŭ����
// "�г�"�� Ű���尡 �������� �̺�Ʈ�� ó���ϱ����Ͽ� "KeyListener" �������̽� ����
public class MyPanel extends JPanel implements KeyListener{
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	Explosion explosion;
	
	//�г��� �����ʰ� ���ÿ� ����
	public MyPanel() {
		super();
		//�г��� Ű���� �̺�Ʈ�� ���
		addKeyListener(this);
		//�г��� Ű���� ��û�� ���� A
		requestFocus();
		//�гο� ��Ŀ���� ���� B
		setFocusable(true);
		//�г��� ȭ�鱸����� �� Ű���带 �Է¹޴� �뵵�� �ƴϱ⿡
		//A,B�� ����Ͽ� Ű����κ��� �Է��� �޾Ƶ��̰� �� -- "�г�"�� "��Ŀ��"�� ����
		
		//�̹��� ���ϸ��� ������ ��ü ����
		enermy = new Enermy("enermy.png");
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		//explosion = new Explosion("explosion.png");
		
		//"�г�"�� ��������� "��", "�̻���", "���ּ�"�� ���� ����������(�����ϸ� �����ϰ�) �����̵��� �ϱ� ���Ͽ�
		//"��Ƽ ������"�� ����
		// "��", "�̻���", "���ּ�"�� ���ÿ� �����̰� �ϴ� ����� �ٸ� �������� �ʿ䰡 ���⶧����
		// �̰� "�г�"������ �ʿ��ϴ�
		// Ŭ������ Ŭ���� �ȿ� ����
		// �̷��� Ŭ������ inner class��� ��
		class MyThread extends Thread{
			
			public void run() {
				while(true) {
					
					//��ġ�� �����ϴ� �޼ҵ� ȣ��
					enermy.update();
					//spaceship.update(); -- ���ּ��� Ű���尡 ������ �������� �ѹ��� �ѹ� �����̵��� �Ǿ� �־� ȣ������ �ʾƵ���
					missile.update();
					
					//"��"�� "�̻���"�� �¾Ҵ��� �Ǻ��Ͽ� ���ִ� �޼ҵ�ȣ��
					enermy.crush(missile);
					
					//"��", "�̻���", "���ּ�"�� ����� ��ġ�� �ٽ� �׸���� ��û�� �ϴ� �޼ҵ�� 
					//repaint�� ȣ���ϸ� paintComponent�޼ҵ尡 ����
					//paintComponent�޼ҵ�� �׷����� ȭ�鿡 �׷��ִ� �޼ҵ�
					repaint();
					/*
					if(enermy.x == missile.x) {
						explosion.update(enermy.x);
						enermy.x = -150;
						missile.x = -150;
					}//end if
					*/
					
					try {
						Thread.sleep(20);
					}catch (Exception e) {
					}//end try,catch
				}//end while
				
				
			}//end run()
		}//end MyThread
		
		//��Ƽ������ ��ü MyThread ����
		//is a �����̱⿡ Thread�� MyThread�� ������ �� �ִ�.
		Thread t = new MyThread();
		
		//�����带 ����
		t.start();
	}// end MyPanel ������
		
		//"��", "�̻���", "���ּ�"�� ����� ��ġ�� �׷����� �ٽ� �׷���
		//"�г�"�� �׷����� ǥ���ϱ� ���ؼ��� paintComponent �������̵�
		//�̶� �Ű������� ���޹��� Graphics���� �׷����� ǥ���ϱ����� �پ��� �޼ҵ���� �ִ�
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//�׷����� �׸��� ���� �׷��Ƚ��� g�� �����Ͽ� �ٽ� ����� ��ġ�� �׸����� �Ѵ�.
			enermy.draw(g);
			spaceship.draw(g);
			missile.draw(g);
			//explosion.draw(g);
		}
		
		//KeyListener �������̽��� �޼ҵ� �������̵�
		public void keyPressed(KeyEvent event) {
			
			//������ Ű�����̺�Ʈ�� ������ ����
			spaceship.keyPressed(event);
			missile.keyPressed(event, spaceship.x,spaceship.y);
		}

		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	
}
