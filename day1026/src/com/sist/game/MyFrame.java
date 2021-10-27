package com.sist.game;

import javax.swing.JFrame;

//GUI 프로그래밍에서
// "창"을 만들기 위해서는 JFrame을 상속받는다.
public class MyFrame extends JFrame {
	
	public MyFrame() {
		//창의 제목 설정
		setTitle("My Game");
		
		//프레임에 추가하는데 MyPanel을 생성해서 추가한다.
		//MyPanel에는 우주선,적,미사일을 포함하고 "패널"
		add(new MyPanel());
		
		//프레임의 사이즈 설정
		setSize(700, 700);
		
		// 프레임을 화면에 보이도록 설정
		setVisible(true);
	}
	public static void main(String[] args) {
		//프레임 생성
		new MyFrame();
	}

}
