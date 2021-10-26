package com.sist.game;

import java.awt.event.KeyEvent;
// ���ּ��� ���� Ŭ����
public class SpaceShip extends GraphicObject {
	
	// ���� ��, �̹������ϸ��� �Ű������� ���޹޾� �θ�����ڿ� ����
	public SpaceShip(String name) {
		super(name);
		
		//��ó�� �����Ҷ��� ���ּ� ��ġ ����
		x = 150;
		y = 350;
	}
	
	//���ּ��� ������ ����Ű�� ���� ���ּ� ��ġ�� �̵���ų �޼ҵ�
	//�Ű������� ���޹��� KeyEventŬ������ event�� ���ؼ� �Ű�� ���������� �� �� ����.
	public void keyPressed(KeyEvent event) {
		
		// ���� ����Ű�� �������� x��ǥ�� �������� �̵���ų����
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		}
		
		// ������ ����Ű�� �������� x��ǥ�� ���������� �̵���ų����
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		}
		// ���� ����Ű�� �������� y��ǥ�� -10 �������� �̵���ų����
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
		}
		// �Ʒ��� ����Ű�� �������� y��ǥ�� �Ʒ������� �̵���ų����
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
		}
		
		
	}
}
