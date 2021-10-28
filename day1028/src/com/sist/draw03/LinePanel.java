package com.sist.draw03;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class LinePanel extends JPanel implements MouseListener{
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//�����ڿ��� "���콺 �̺�Ʈ"�� ������ش�
	public LinePanel() {
		//this�� ���콺�̺�Ʈ�� �߻��Ͽ��� �� �̺�Ʈó�� ��簴ü�� LinePanelŬ���� �ڽ��Դϴٶ�� �˷��ִ°�
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("�ٽ� �׷��ݴϴ�.");
		g.drawLine(x1,y1,x2,y2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
