package com.sist.game;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
//��,���ּ�,�̻��� Ŭ�������� ���������� �������� �Ӽ��� ������ �̾� "�Ϲ�ȭ"�Ѵ�.
public class GraphicObject {
	
	BufferedImage img = null; // ȭ���� �׸��� ǥ���ϱ����� ��ü
	int x = 0, y = 0; // �׸��� ȭ�鿡 ��µ� ��ġ
	//�����ÿ� �׷����̹��� ���ϸ��� �Ű������� ���޹���
	public GraphicObject(String name) {
		//�Ű������� ���޹��� ���ϸ����� BufferdImage��ü�� ����
		try {
			img = ImageIO.read(new File(name));
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
		
	}
	//�׷��� �̹����� ��ġ�� �����ϱ� ���� �޼����̸� �ڽ�Ŭ�������� �ڽſ��� �µ��� �������ؾ��ϴ� �޼���
	public void update() {}
	//����� ��ġ�� �̹����� �ٽ� �׸��� ���� �޼ҵ�
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null);// img�� x,y��ǥ�� �׷��ش�.
	}
	//��, �̻���, ���ּ� ������ ��ü���� keyPressed�� �ڽſ��� �µ��� �������̵��Ѵ�.
	public void keyPressed(KeyEvent event) {}
}
