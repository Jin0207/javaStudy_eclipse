package com.sist.product;

import java.util.Random;

// �����ڿ� �Һ��ڰ� ������ ��ǰŬ����
public class Product {

	//����Ǵ� ��ǰ�� ������ ����
	int number;
	//��ǰ�� ���� �����Ͽ�����, �Һ��Ͽ����� �Ǻ��ϱ����� ����
	// �����ڰ� ���ο� ��ǰ�� �����ϸ� true�� ����
	// �Һ��ڰ� ��ǰ�� �Һ��ϸ� false
	public boolean isNew = false; 
	
	//�����ڰ� ����� ���ο� ��ǰ�� �����ϴ� �޼ҵ� ����
	//�����ڰ� ��ǰ�� �����ϴ� ���� �Һ��ڰ� ������ �� ������ �ϱ�����
	//"�Ӱ迵��"���μ���
	public synchronized void makeNumber() {
		//���ο� ��ǰ ���� ��, �Һ� �Ͼ������ �����·�
		//�Һ��ڰ� ��ǰ�� �Һ��ϰ� isNew�� false�� �����ϰ� notify�� �����ָ� �ݺ���Ż��
		while(isNew == true) { 
			try {
				wait();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		//���ο� ��ǰ ����
		Random r = new Random();
		number = r.nextInt(100);
		System.out.println("�����ڰ� ���ο� ��ǰ ����: " + number);
		//���ο� ��ǰ�� ����Ǿ��ٴ� ǥ�÷� isNew�� true�� ����
		isNew = true;
		//������� ������(�Һ���)�� ������
		notify();
	}//end ������
	
	//�Һ��ڰ� ����� ��ǰ�� �Һ��ϱ� ���� �޼ҵ� ����
	public synchronized int getNumber() {
		
		//�����ڰ� ���ο� ��ǰ�� ������ ������ �����·� �ֵ����Ѵ�.(���ο� ��ǰ�� �������� �ʴµ���)
		// �����ڰ� ���ο� ��ǰ�� �����ϰ� isNew�� true�� ��� notify�� �����ָ� �ݺ��� Ż��
		while(isNew == false) {
			try {
				wait();
			}catch (Exception e) {
			}
		}
		
		System.out.println("�Һ��ڰ� ��ǰ �Һ���: " + number);
		isNew = false;
		notify();
		return number;
	}
}
