package com.sist.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 버튼에 대한 이벤트 처리를 위해서는 ACtionListener 인터페이스를 구현해야한다.
// 만약, MyFrame자신이 ActionListener 인터페이스를 구현하게되면,
// 하나의 actionPerformed메소드에서 모든 버튼의 이벤트처리를 해야한다.
// 일일히 누가(무엇) 눌러졌는지 판단해야하기에 버튼이 많으면 판단하는 if가 복잡해 질 수 있다.
// 그래서 버튼하나당 일처리 담당객체를 이름없는 inner 클래스로 만들어 처리한다.
public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		JButton btn01 = new JButton("남자");
		JButton btn02 = new JButton("여자");
		
		setLayout(new FlowLayout());
		
		add(btn01);
		add(btn02);
		
		//btn-1.addActionListener(this); 이 this는 ActionListener 인터페이스를 구현한 담당객체여야해
		
		btn01.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("남자입니다.");
			}
		});
		
		btn02.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("여자입니다.");
			}
		});
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
