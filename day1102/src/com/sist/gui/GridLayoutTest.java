package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
public class GridLayoutTest extends JFrame {
	
	public GridLayoutTest() {
		//�������� 5�� 3���� �׸��巹�̾ƿ����� ����
		setLayout(new GridLayout(5,3));
		
		//�ݺ����� �̿��Ͽ� 15���� ��ư�� �����Ͽ� �����ӿ� ���
		for(int i = 1; i <= 15; i++) {
			add(new JButton("��ư" + i));
		}
		
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new GridLayoutTest();
	}

}
