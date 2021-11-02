package com.sist.gui;

import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {
	
	public JButtonTest02(){
		//버튼을 생성하여 창 안에 버튼을 추가
		JButton btn01 = new JButton("버튼1");
		JButton btn02 = new JButton("버튼2");
		
		add(btn01);
		add(btn02);
		
		// 생성시에 자동으로 설정하도록 함
		// 객체만 생성해주면 자동으로 창의 사이즈를 정해주고, 창을 보여주니 
		// 변수이름을 굳이 줄 필요 없이 객체생성만 해도 된다.
		setSize(400, 300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		new JButtonTest02();
		
	}

}
