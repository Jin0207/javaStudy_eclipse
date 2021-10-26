package com.sist.game;

import java.util.Random;

public class Enermy extends GraphicObject {
	// ���� x������ �����̴� ������ ���� ����
	// ��ó������ ������ ���� ���� ��ġ�Ͽ����� �������ΰ������� ��������
	int dx = -10;
	
	//���� ��, "��"���� ǥ���� �׷��� �����̸��� �Ű������� ���޹޾� �θ�Ŭ������ �����ڿ��� ����
	public Enermy(String name) {
		super(name);
		
		// "��"�� ���۵Ǵ� ��ġ
		// ������ �ǳ� ��ܿ� ��ġ��Ŵ
		x = 500;
		y = 0;
	}
	public void randomLocation() {
			x = new Random().nextInt(400);
	}
	
	public void update() {
		// x��ǥ�� dx��ŭ �����Ŵ		
		x += dx;

		
		//����, ���ʳ��� �����Ͽ��ٸ� x�� < 0 �Ŵϱ� ���������� �̵���Ű������ dx�� ����� ����
		if(x < 0) {
			dx = 10;
		}
		if(x == new Random().nextInt(400))
		//����, ������ ���� �����Ͽ��ٸ� �ٽ� �������� �̵���Ű������ dx�� ������ ����
		if(x > 500) {
			dx = -10;
		}
	}
}
