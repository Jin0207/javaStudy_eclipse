package com.sist.goods03;
//JTable�� �߰��Ͽ� ��ǰ����� ���̵��� �����غ���

import javax.swing.JButton;
import java.awt.event.MouseListener;

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
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
public class GoodsTest extends JFrame {
	
	JTextField jtf_no;		//��ǰ��ȣ�� �Է¹ޱ� ���� �Է»���
	JTextField jtf_item;	//��ǰ���� �Է¹ޱ� ���� �Է»���
	JTextField jtf_qty;		//������ �Է¹ޱ� ���� �Է»���
	JTextField jtf_price;	//������ �Է¹ޱ� ���� �Է»���
	
	JTable table; 			//��� ��ǰ����� ������ ���� ������� �����ֱ� ���� ���̺� ����
	Vector colNames; //���̺��� Į���̸��� ���� ���ͼ���
	Vector<Vector> rowData;  //���̺��� �����͸� ���� ���͸� ����
	
	// �����ͺ��̽��� �����Ͽ� �߰�, ���, ����, ���� ����� ���� �ִ� 
	// dao�� ����� ����
	GoodsDao dao;
	public void printGoods() {
		
		rowData.clear();
		
		ArrayList<GoodsVo> list = dao.listGoods();
		//list�� ��� GoodsVo�� �ϳ��� �����ͼ� ���̺� �����͸� ǥ���ϱ����� roewData����ƿ�
		for(GoodsVo g : list) {
			Vector v = new Vector();
			v.add(g.getNo());
			v.add(g.getItem());
			v.add(g.getQty());
			v.add(g.getPrice());
			
			rowData.add(v);
		}
		//���̺��� �ٽ� �׷��ּ���
		table.updateUI();
	}
	
	public GoodsTest() {
		
		//dao�� ����
		dao = new GoodsDao();
		
		//���̺� �� Į���̸��� ���� ���͸� �����ϰ� �ڷḦ �߰�
		colNames = new Vector<String>();
		colNames.add("��ǰ��ȣ");
		colNames.add("��ǰ��");
		colNames.add("����");
		colNames.add("�ܰ�");
		
		//���̺� �� ���������͸� ������� ���͸� �����ϰ� �ڷḦ �߰�
		rowData = new Vector<Vector>();
		
		// �÷��̸��� �ִ� colNames ���Ϳ� ���� �����Ͱ� �ִ� rowData ���͸� ���� ���̺� ����(������ ���� ȭ���� ������)
		table = new JTable(rowData, colNames);
		
		//���̺� �ڷᰡ �ʹ� ����, �� ȭ�鿡�� ������ ���� ���� �ڵ����� ��ũ���� ������ִ� JScrollPane
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();
		
		//�Է»��ڵ�� ������ �Է��ؾ��ϴ� �� �����ϴ� �󺧵��� ��� ���� �г� ����
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 2));
		
		//�󺧰� �Է»��ڵ��� �гο� ���ʷ� ��ƿ�
		p.add(new JLabel("��ǰ��ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("��ǰ�̸�:"));
		p.add(jtf_item);
		p.add(new JLabel("��ǰ����:"));
		p.add(jtf_qty);
		p.add(new JLabel("��ǰ�ܰ�:"));
		p.add(jtf_price);
		
		// "�߰�" �۾��� ������ ��ư�� ������
		JButton btn_add = new JButton("�߰�");
		
		// "���" �۾��� ������ ��ư�� ������
		JButton btn_list = new JButton("���");
		
		// "���" �۾��� ������ ��ư�� ������
		JButton btn_update = new JButton("����");
		
		// "���" �۾��� ������ ��ư�� ������
		JButton btn_delete = new JButton("����");
		
		// ��ư���� ��� JPanel
		//�г��� �⺻�� FlowLayout
		JPanel p2 = new JPanel();
		
		p2.add(btn_add);
		p2.add(btn_list);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		// �Է»��ڵ��� �гΰ� ��ư���� �г��� ������� JPanel
		JPanel p_center = new JPanel();
		
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p2, BorderLayout.SOUTH);
		
		//�������� ����� �Է»��ڿ� ��ư�� ����ִ� p_center�г��� ����
		add(p_center, BorderLayout.CENTER);
		
		//���̺��� ����ִ� ScrollPane�� �������� �Ʒ��ʿ� ��ƿ�
		add(jsp, BorderLayout.SOUTH);
		
		//�������� ����,���� ���� ����, ȭ�鿡 �����ֵ��� ����
		setSize(800, 600);
		setVisible(true);
		
		//â�� ������ ���α׷��� �����ϵ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//"����" ��ư�� ������ ������ ��ǰ�� �������� �ؽ�Ʈ�ʵ�� ������ ��
		//�װ��� �޼ҵ忡�� �����Ͽ� �����ϵ���
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				GoodsVo g = new GoodsVo(no, item, qty, price);
				
				int re = dao.updateGoods(g);
				//�� VO�� dao�� insertGoods�� �����Ѵ�.
				if(re == 1) {
					System.out.println("��ǰ������ �����Ͽ����ϴ�.");
					printGoods();
				}else {
					System.out.println("��ǰ������ �����Ͽ����ϴ�.");
				}
			}
		});
		
		//"����" ��ư�� ������ �ؽ�Ʈ�ʵ��� ��ǰ��ȣ�� ����ͼ�, �������ϴ¸޼ҵ�ȣ��
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				int re = dao.deleteGoods(no);
				if(re == 1) {
					System.out.println("��ǰ�� �����Ͽ����ϴ�..");
					printGoods();
				}else {
					System.out.println("��ǰ ������ �����Ͽ����ϴ�");
				}
				
			}
		});
		
		//"���" ��ư�� ������
		//�����ͺ��̽� �����Ͽ� ��� ��ǰ����� �о�ͼ� ���̺� ����ϴ� �޼ҵ带 ȣ��
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printGoods();
			}
		});
		
		//�߰���ư�� ������ ����ڰ� �Է��� ��ǰ��ȣ, ��ǰ�̸�, ��ǰ����, ��ǰ�������� 
		//���������̺� �ڷḦ �߰��ϵ��� �Ѵ�.
		btn_add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				//����ڰ� �Է��� ��ǰ��ȣ, ��ǰ��, ����, ������ ���� Vo�� ����
				GoodsVo g = new GoodsVo(no, item, qty, price);
				
				int re = dao.insertGoods(g);
				//�� VO�� dao�� insertGoods�� �����Ѵ�.
				if(re == 1) {
					System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
					printGoods();
				}else {
					System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
				}
			}//end actionPerformed
		});
		
		//���̺� ���콺 �̺�Ʈ ����Ͽ� ������ ���� ��ǰ������
		// ������ �Է»��ڿ� ���
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int index = table.getSelectedRow();
				
				//rowData�� index��°�� ���͸� �������´�.
				Vector data = rowData.get(index);
				
				//�� ������ ��Ҹ� ���ʷ� �Է»��ڿ� ����Ѵ�.
				jtf_no.setText(data.get(0) + "");
				jtf_item.setText(data.get(1) + "");
				jtf_qty.setText(data.get(2) + "");
				jtf_price.setText(data.get(3) + "");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});

	}//end ������
	
	public static void main(String[] args) {
		new GoodsTest();
	}

}
