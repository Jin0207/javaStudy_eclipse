package com.sist.game;
import java.awt.event.KeyEvent;
public class Missile extends GraphicObject {
	//�����̽��ٸ� ������ ��, �̻����� �߻�Ǵ� �̻����� �߻�Ǿ����� �˷��ִ� ����
	boolean launched = false;
	
	//���� �� �̹��� �����̸��� �Ű������� ���޹޾� �θ��� �����ڿ��� ����
	public Missile(String name) {
		super(name);
		y = -150;
	}
	
	public void update() {
		//���࿡ �̻����� �߻� �Ǿ��ٸ� y��ǥ�� 1�� ����
		if(launched) {
			y -= 30;
		}
		
		//�̻����� y��ǥ�� ȭ�� �� �����̸� launched�� false����
		if(y < -100) {
			launched = false;
			y = -150;
			x = -1000;
		}
				
	}
	// Ű���尡 ��������, ���� ���ּ��� �ִ� ��ġ x,y��ǥ����
	// �̻����� �߻��Ű������ �޼��� keyPressed�޼��� �������̵�
	// �Ű������� ���޹޴� KeyEvent�� event�� ���ؼ� � key�� ���������� �˼��ִ�
	// ��, �Ű����� x,y�� ���ּ��� ��ġ x,y�� ���޹���
	public void keyPressed(KeyEvent event, int x, int y) {
		
		//������ Ű�� �����̽��ٶ�� �̻��� �߻�
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;
			
			//�̻����� x,y��ǥ�� ���ּ��� x,y�� ����
			this.x = x;
			this.y = y;
		}
	}
}
