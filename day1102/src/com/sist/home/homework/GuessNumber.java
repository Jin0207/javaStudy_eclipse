package com.sist.home.homework;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GuessNumber extends JFrame implements ActionListener{
	
	Random r = new Random();
	JTextField title;
	JTextField answer_u;
	JTextField hint;
	JButton btn_re;
	JButton btn_close;
	JButton btn_send;
	int answer;
	
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public GuessNumber() {
		setLayout(new GridLayout(4,1));
		
		answer = r.nextInt(100) + 1;
		System.out.println(answer);
		title = new JTextField("숫자게임");
		answer_u = new JTextField(10);
		hint = new JTextField();
		btn_send = new JButton("제출");
		btn_re = new JButton("다시하기");
		btn_close = new JButton("종료");
		
		JPanel p = new JPanel();
		JPanel p_btn = new JPanel();
		
		p.add(new JLabel("숫자를 추측하시오: ")); 
		p.add(answer_u);
		p.add(btn_send);
		
		p_btn.add(btn_re);
		p_btn.add(btn_close);
		
		add(title);
		add(p);
		add(hint);
		add(p_btn);
		
		btn_re.addActionListener(this);
		btn_close.addActionListener(this);
		btn_send.addActionListener(this);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		int re = getAnswer();
		System.out.println(cmd);
		if(cmd.equals("다시하기")) {
			answer_u.setText("");
			answer = r.nextInt(100) + 1;
			hint.setText("");
			System.out.println(answer);
		}else if(cmd.equals("제출")) {
			int user = Integer.parseInt(answer_u.getText());
			if(user == answer) {
				hint.setText("정답입니다.");
			}else if(user > answer) {
				hint.setText("너무 큽니다");
			}else if(user < answer) {
				hint.setText("너무 작습니다.");
			}
		}else {
			System.exit(0);
		}
		
	}

}
