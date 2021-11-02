package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
//FlowLayout 이해하기
public class FlowLayoutTest extends JFrame {
	
	public FlowLayoutTest() {
		
		//프레임에 FlowLayout 설정
		setLayout(new FlowLayout());
		
		//반복문을 이용하여 버튼 15개를 생성하여 프레임에 추가해보자
		for(int i = 1; i <= 15; i++) {
			add(new JButton("버튼 " + i));
		} 
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest();
	}

}
