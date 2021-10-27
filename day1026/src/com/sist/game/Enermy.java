package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	// ���� x������ �����̴� ������ ���� ����
	// ��ó������ ������ ���� ���� ��ġ�Ͽ����� �������ΰ������� ��������
	//int dx = -10;
	//int dy = 10;
	
	//���� �̵���θ� ������
			int dx;
			int dy;
			
	//���� ��, "��"���� ǥ���� �׷��� �����̸��� �Ű������� ���޹޾� �θ�Ŭ������ �����ڿ��� ����
	public Enermy(String name) {
		super(name);
		
		// "��"�� ���۵Ǵ� ��ġ
		// ������ �ǳ� ��ܿ� ��ġ��Ŵ
		//x = 500;
		//y = 0;
		
		Random r = new Random();
		//�� ó���� ���� ��ġ�� ������ ����
		x = r.nextInt(500);
		y = r.nextInt(300);
		
		//���� �̵���ΰ��� �����ÿ� ������ ����
		//�̵��ϴ� �ּҰ�: 10, �ִ밪: 40
		// � ������ ���� 90���� ���� ������ 10�� ���Ѵ�
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
		// x��ǥ�� dx��ŭ �����Ŵ		
		x += dx;
		y += dy;
		
		
		
		//x������ ���� ���������� ��ȣ�� �ٲ���
		if(x < 0 || x > 500) {
			dx = dx * -1;
		}
		
		//y������ ���� ���������� ��ȣ�� �ٲ���
		if(y < 0 || y > 500) {
			dy = dy * -1;
		}
		/*
		//����, ���ʳ��� �����Ͽ��ٸ� x�� < 0 �Ŵϱ� ���������� �̵���Ű������ dx�� ����� ����
		if(x < 0) {
			dx = 10;
		}
		
		//����, ������ ���� �����Ͽ��ٸ� �ٽ� �������� �̵���Ű������ dx�� ������ ����
		if(x > 500) {
			dx = -10;
		}
		
		if(y > 400) {
			dy = -10;
		}
		if(y < 0 ) {
			dy = 10;
		}
		*/
	}
	
	// "�̻���"�� �¾Ҵ��� �Ǻ��ϴ� �޼ҵ� ����
	// �̻����� ��ġ�� �ʿ���
	// �Ű������� �̻�����ü�� �ص��ǰ� �̻����� ��ġ������ �ص��ȴ�.
	public void crush( Missile missile ){
		//���� ũ�⿡���� �̻����� �¾Ѵ��� �ȸ¾Ѵ��� �Ǻ��ؾ��Ѵ�.
		if(x <= missile.x && missile.x <= x + 100 && y <= missile.y && missile.y <= y + 90) {
			//�Ҹ����� ��ü ����
			File file = new File("EXPLODE.WAV");
			
			try {
				//����� ������ �о�������� �غ�
				Clip clip = AudioSystem.getClip();
				
				//����� ������ �о�´�
				clip.open(AudioSystem.getAudioInputStream(file));
				
				//��������� ���
				clip.start();
			}catch (Exception e) {
			}
			
			y = -1000;
		}
	}
	
}
