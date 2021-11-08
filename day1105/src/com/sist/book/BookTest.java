package com.sist.book;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BookTest extends JFrame{
	
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_publisher;
	JTextField jtf_price;
	JTable table;
	Vector<Vector> rowData;
	Vector colNames;
	
	BookDao dao;
	public void clearJtf() {
		jtf_no.setText("");
		jtf_name.setText("");
		jtf_publisher.setText("");
		jtf_price.setText("");
	}
	
	public void printlist() {
		rowData.clear();
		
		ArrayList<BookVo> list = dao.listBook();
		
		for(BookVo vo : list) {
			Vector v = new Vector();
			
			v.add(vo.getNo());
			v.add(vo.getName());
			v.add(vo.getPublisher());
			v.add(vo.getPrice());
			
			rowData.add(v);
		}
		table.updateUI();
	}
	
	public BookTest() {
		dao = new BookDao();
		
		//테이블
		colNames = new Vector();
		rowData = new Vector<Vector>();
		
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("출판사");
		colNames.add("가격");
		
		table = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		//텍스트필드
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_publisher = new JTextField();
		jtf_price = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		p.add(new JLabel("도서번호:"));
		p.add(jtf_no);
		p.add(new JLabel("도서명:"));
		p.add(jtf_name);
		p.add(new JLabel("출판사:"));
		p.add(jtf_publisher);
		p.add(new JLabel("가격:"));
		p.add(jtf_price);
		
		//버튼
		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		JPanel p_btn = new JPanel();
		p_btn.add(btn_add);
		p_btn.add(btn_list);
		p_btn.add(btn_update);
		p_btn.add(btn_delete);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p_btn, BorderLayout.SOUTH);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String publisher = jtf_publisher.getText();
				int price = Integer.parseInt(jtf_price.getText());
				
				int re = dao.addBook(new BookVo(no, name, publisher, price));
				
				if(re == 1) {
					System.out.println("도서를 추가하였습니다.");
					printlist();
					clearJtf();
				}else {
					System.out.println("도서 추가에 실패하였습니다.");
				}
			}
		});//end btn_add
		
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printlist();
			}
		});
		
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String publisher = jtf_publisher.getText();
				int price = Integer.parseInt(jtf_price.getText());
				
				int re = dao.updateBook(new BookVo(no, name, publisher, price));
				
				if(re == 1) {
					System.out.println("도서를 수정하였습니다.");
					printlist();
					clearJtf();
				}else {
					System.out.println("도서 수정에 실패하였습니다.");
				}
			}
		});//end btn_update
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				int re = dao.deleteBook(no);
				
				if(re == 1) {
					System.out.println("도서를 삭제하였습니다.");
					printlist();
					clearJtf();
				}else {
					System.out.println("도서 삭제에 실패하였습니다.");
				}
			}
		});//end btn_delete
		
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
				
				Vector data = rowData.get(index);
				
				jtf_no.setText(data.get(0)+"");
				jtf_name.setText(data.get(1)+"");
				jtf_publisher.setText(data.get(2)+"");
				jtf_price.setText(data.get(3)+"");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});//end mouseListener
	}
	
	public static void main(String[] args) {
		new BookTest();
	}

}
