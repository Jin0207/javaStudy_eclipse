package com.sist.book;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
public class OrderTestGUI extends JFrame {
	
	JTextField jtf_custid;
	JTable table;
	// ���̺��� ���� == '��Ӹ�'
	Vector colNames;
	// ���������͸� ǥ���ϴ� ��ü
	Vector<Vector> rowData;
	
	OrdersDAO dao;
	
	public OrderTestGUI() {
		
		jtf_custid = new JTextField(10);
		
		//table�� �����ϱ����ؼ��� colNames, rowData�� �����Ǿ� �־���Ѵ�
		colNames = new Vector();
		
		colNames.add("�ֹ���ȣ");
		colNames.add("����ȣ");
		colNames.add("������ȣ");
		colNames.add("���űݾ�");
		colNames.add("��������");
		
		rowData = new Vector<Vector>();
		table = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		JButton btn = new JButton("�˻�");
		JPanel p = new JPanel();
		p.add(new JLabel("�˻��� �� ��ȣ�� �Է��ϼ��� : "));
		p.add(jtf_custid);
		p.add(btn);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rowData.clear();
				int custid = Integer.parseInt(jtf_custid.getText());
				dao = new OrdersDAO();
				ArrayList<OrdersVO> list = dao.searchOrders(custid);
				
				for(OrdersVO vo : list) {
					Vector v = new Vector();
					v.add(vo.getOrderid());
					v.add(vo.getCustid());
					v.add(vo.getBookid());
					v.add(vo.getSaleprice());
					v.add(vo.getOrderdate());
					
					rowData.add(v);
				}
				table.updateUI();
			}});
	
	}
	
	public static void main(String[] args) {
		new OrderTestGUI();
	}

}
