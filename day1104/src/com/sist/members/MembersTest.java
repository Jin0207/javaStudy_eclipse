package com.sist.members;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.Vector;
import java.awt.BorderLayout;
//ȸ����ȣ, ȸ���̸�, �ּ�, ����, ��ȭ��ȣ�� �����ϱ� ���� �����ͺ��̽� ���̺��� �����ϰ�
//CURD�� ������ ���α׷��� �ۼ��غ���
public class MembersTest extends JFrame{
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_addr;
	JTextField jtf_age;
	JTextField jtf_phone;
	
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	
	public MembersTest() {
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_addr = new JTextField();
		jtf_age = new JTextField();
		jtf_phone = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5, 2));
		p.add(new JLabel("ȸ����ȣ"));
		p.add(jtf_no);
		p.add(new JLabel("ȸ���̸�"));
		p.add(jtf_name);
		p.add(new JLabel("�ּ�"));
		p.add(jtf_addr);
		p.add(new JLabel("����"));
		p.add(jtf_age);
		p.add(new JLabel("��ȭ��ȣ"));
		p.add(jtf_phone);
		
		JButton btn_search =new JButton("��ȸ");
		JButton btn_add =new JButton("�߰�");
		JButton btn_update =new JButton("����");
		JButton btn_delete =new JButton("����");
		
		JPanel p2 = new JPanel();
		p2.add(btn_search);
		p2.add(btn_add);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p2, BorderLayout.SOUTH);
		
		colNames = new Vector<String>();
		
		colNames.add("ȸ����ȣ");
		colNames.add("ȸ���̸�");
		colNames.add("�ּ�");
		colNames.add("����");
		colNames.add("��ȭ��ȣ");
		
		rowData = new Vector<Vector>();
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);
		
		setSize(800, 600);
		setTitle("ȸ��������ȸ");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MembersTest();
	}

}
