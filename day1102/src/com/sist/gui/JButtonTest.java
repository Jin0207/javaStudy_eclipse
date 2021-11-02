package com.sist.gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class JButtonTest extends JFrame {
	
	public JButtonTest(){
		
	}

	public static void main(String[] args) {
		
		//우리가 만든 JButtonTest가 곧 JFrame
		// JButtonTest가 JFrame을 상속받았기 때문에
		// 아래 코드로 창을 생성하였지만 창이 실제로 모이지는 않음
		// 만든 창을 보이게 하려면, 창의 가로, 세로 길이를 설정해 화면에 보이도록 설정해야한다.
		JButtonTest f = new JButtonTest();
		
		// 밑에 코드를 입력해서 창의 가로세로를 정해주고
		// 창이보이도록 설정해준다.
		f.setSize(400, 300);
		f.setVisible(true);
		
		//창을 닫았을 때, 프로그램도 같이 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
