package com.sist.goods;
//JTable�� �߰��Ͽ� ��ǰ����� ���̵��� �����غ���

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
public class GoodsTestDB extends JFrame {
	
	JTextField jtf_no;		//��ǰ��ȣ�� �Է¹ޱ� ���� �Է»���
	JTextField jtf_item;	//��ǰ���� �Է¹ޱ� ���� �Է»���
	JTextField jtf_qty;		//������ �Է¹ޱ� ���� �Է»���
	JTextField jtf_price;	//������ �Է¹ޱ� ���� �Է»���
	
	JTable table; 			//��� ��ǰ����� ������ ���� ������� �����ֱ� ���� ���̺� ����
	Vector colNames; //���̺��� Į���̸��� ���� ���ͼ���
	Vector<Vector> rowData;  //���̺��� �����͸� ���� ���͸� ����
	
	//�����ͺ��̽��� �����Ͽ� goods���̺��� ��� ��ǰ�� �о�ͼ�(�˻��Ͽ�, ��ȸ�Ͽ�)
	// JTable�� ����ϴ� �޼ҵ�
	public void printGoods() {
		//���ο� ��ǰ�� ����Ͽ� ����Ͽ� ȣ�⵵�� �� ������,
		//rowData�� ���� ������ ����ش�.
		rowData.clear();
		
		//�����ͺ��̽��� �����Ͽ� ������ ��ɾ�
		String sql = "select * from goods";
		
		//�����ͺ��̽� ����� �ʿ��� ������ ����
		Connection conn = null;		//DB������ ������ ���� ����
		Statement stmt = null; 	 	// �����ͺ��̽� ����� �����ϱ� ���� ����
		ResultSet rs = null;	 	//�о�� �ڷḦ ������� ����
		
		try {
			//1. jdbc����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db������ �����Ѵ�.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			
			//3. statement��ü�� �����Ѵ�.
			stmt = conn.createStatement();
			
			//4. �����ͺ��̽� ����� �����Ѵ�.
			// ����ϴ� �޼ҵ� �ΰ��� 
			//executeUpdate : �ڷḦ �߰�, ����, �����ϰ� int�� ��ȯ 
			//executeQuery : �ڷḦ �о�ͼ� ResultSet���� ��ȯ
			rs = stmt.executeQuery(sql);
			
			//5. ��ó���� �Ѵ�.
			// �˻��� �ڷᰡ �ִ� ��ŭ �ݺ������Ͽ� �� �྿ �о�ͼ� �װ��� ���ͷ� �����
			// �� ���͸� ���̺��� �ڷḦ ���� rowData�� ��ƿ�
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				
				//���͸� �ϳ� ����� �� ���Ϳ� no,item,qty,price�� ��´�.
				Vector v = new Vector();
				v.add(no);
				v.add(name);
				v.add(qty);
				v.add(price);
				
				// �� ���͸� rowData�� ��´�.
				rowData.add(v);
				
				//�ٲ� �������� ���̺��� �ٽñ׷���
				//ó�� ���̺��� ���� ������ rowData���Ͱ� ����־���
				// ���߿� ���̺��� �������� rowData�� �ٲ��ڷḦ �����ϱ� ���ؼ��� 
				// updateUI ȣ���ؾ��Ѵ�.
				table.updateUI();
			}
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}finally {
			
			try {
				//����ߴ� �ڿ��� �ݾ��ݴϴ�. ������x
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
			}
		}// end finally
	}
	
	
	
	public GoodsTestDB() {
		
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
		
		// ��ư���� ��� JPanel
		JPanel p2 = new JPanel();
		//�г��� �⺻�� FlowLayout
		
		p2.add(btn_add);
		p2.add(btn_list);
		
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
				
				String sql = "insert into goods values("+ no +",'" + item + "'," + qty +"," + price + ")";
				
				// finally ������ ������ �� �ֵ��� Connection ������ Statement ������ try�� �ٱ��� ����
				Connection conn = null;
				Statement stmt = null;
				
				
				try {
					// 1. jdbc����̹��� �޸𸮷� �ε��Ѵ�.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// 2. DB������ �����Ѵ�.
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					
					// 3. �����ͺ��̽� ����� ������ �� �ִ� Statement ��ü����
					stmt = conn.createStatement();
					
					// 4. �����ͺ��̽� ��� ����
					int re = stmt.executeUpdate(sql);
					
					if(re == 1) {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
						
						
						//��ǰ����� �����ϸ� ���̺��� ������ �ٽ� �о������ �޼ҵ带 ȣ���մϴ�.
						printGoods();
						
					}else {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
					}
					
				}catch (Exception ex) {
					System.out.println("���ܹ߻�: " + ex.getMessage());
				}finally {
					//close() ���ܸ� �Ȱ� ����
					try {
						// 5. ����ߴ� �ڿ����� �ݾ��ش�
						if(stmt != null) stmt.close();
						
						if(conn != null) conn.close();
						
					}catch (Exception ex) {
						// TODO: handle exception
					}
				}//end finally
			}//end actionPerformed
		});// end actionPerformed()
	}//end ������
	
	public static void main(String[] args) {
		new GoodsTestDB();
	}

}
