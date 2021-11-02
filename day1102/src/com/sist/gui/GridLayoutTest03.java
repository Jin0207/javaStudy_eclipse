package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
public class GridLayoutTest03 extends JFrame {
	
	public GridLayoutTest03() {
		//프레임을 5행 3열의 그리드레이아웃으로 설정
		setLayout(new GridLayout(5,3));
		
		//반복문을 이용하여 14개의 버튼을 생성하여 프레임에 담기
		for(int i = 1; i <= 14; i++) {
			add(new JButton("버튼" + i));
		}
		
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new GridLayoutTest03();
	}

}
