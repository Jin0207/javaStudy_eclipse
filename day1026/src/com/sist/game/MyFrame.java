package com.sist.game;

import javax.swing.JFrame;

//GUI ���α׷��ֿ���
// "â"�� ����� ���ؼ��� JFrame�� ��ӹ޴´�.
public class MyFrame extends JFrame {
	
	public MyFrame() {
		//â�� ���� ����
		setTitle("My Game");
		
		//�����ӿ� �߰��ϴµ� MyPanel�� �����ؼ� �߰��Ѵ�.
		//MyPanel���� ���ּ�,��,�̻����� �����ϰ� "�г�"
		add(new MyPanel());
		
		//�������� ������ ����
		setSize(700, 700);
		
		// �������� ȭ�鿡 ���̵��� ����
		setVisible(true);
	}
	public static void main(String[] args) {
		//������ ����
		new MyFrame();
	}

}
