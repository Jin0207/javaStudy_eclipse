package com.sist.numberguess;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;
public class NumberGuess extends JFrame implements ActionListener{
	//����ڰ� ���ڸ� �Է��ϱ� ���� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField jtf;
	
	//����ڰ� �Է��� ���ڰ� ��ǻ�Ͱ� ������ ���ڿ� ���߾����� �� ū�� �� ������ ����� ����� ���� ��������� ����
	//JLabel result;
	JTextField result;
	
	// ������ �����ϱ� ���� ������ ��������� ����
	int num;
	
	
	public NumberGuess() {
		
		// ������ �����Ͽ� ������� num�� ����
		Random r = new Random();
		num = r.nextInt(100) + 1;
		System.out.println(num);
		//������� �ؽ�Ʈ�ʵ�� ���� ����
		jtf = new JTextField(10);
		result = new JTextField("                 ���⿡ ����� ��Ÿ���ϴ�,                          ");
		
		// �������� ��ġ����� �÷ο� ���̾ƿ����� ����
		setLayout(new FlowLayout());
		
		//ȭ�鿡 ������ҵ��� ��ƿ�
		add(new JLabel("���ڸ� �����Ͻÿ�."));
		add(jtf);
		add(result);
		
		// �ΰ��� ��ư ����
		JButton btn01 = new JButton("�ٽ� �ѹ�");
		JButton btn02 = new JButton("����");
		
		add(btn01);
		add(btn02);
		
		//�������� ũ��� �������� ȭ�鿡 ���̵��� ����
		setSize(300, 300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�������� ũ�⸦ ����
		setResizable(false);
		
		// �ΰ��� ��ư�� �̺�Ʈ�� ���
		btn01.addActionListener(this);
		btn02.addActionListener(this);
	}
	public static void main(String[] args) {
		new NumberGuess();
	}
	
	@Override
	//"�ٽ� �ѹ�" ��ư�� ������ "����"��ư�� ������ �� �޼ҵ尡 ����
	public void actionPerformed(ActionEvent e) {
		//� ��ư�� ���������� �Ǵ��ؾ���
		//�׷��� �ϱ� ���ؼ� �Ű����� ActionEvent�� getActionCommand �޼ҵ带 ���
		// ��ư�� ������ ���ڸ� �о��
		String cmd = e.getActionCommand();
		
		if(cmd.equals("�ٽ� �ѹ�")) {
			
			//��ǻ�Ͱ� �����ϰ� �ִ� ������ ����ڰ� �Է��� ���ڰ� �������� �Ǻ�
			int user = Integer.parseInt(jtf.getText());
			
			//������ ��������, �� ū��, �� ������ �Ǻ��Ͽ� ��� ���
			if(user == num) {
				result.setText("                 �����Դϴ�.                          ");
				result.setBackground(Color.BLUE);
				
			}else if(user > num) {
				result.setText("                 �� ū ���ڸ� �Է��߾��!                          ");
				result.setBackground(Color.RED);
				jtf.setText("");
			
			}else {
				result.setText("                 �� ���� ���ڸ� �Է��߾��!                          ");
				result.setBackground(Color.RED);
				jtf.setText("");
				
			}
			
		}else {
			System.exit(0);
		}
	}

}
