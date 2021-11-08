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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
public class BookTest extends JFrame {
	
	JTextField jtf_bookid;
	JTextField jtf_bookname;
	JTextField jtf_publisher;
	JTextField jtf_price;
	
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	ArrayList<BookVO> list;
	BookDAO dao;
	
	BookTest(){
		dao = new BookDAO();
		
		JPanel p_center = new JPanel();
		JPanel p_jtf = new JPanel();
		JPanel p_btn = new JPanel();
		
		rowData = new Vector<Vector>();
		
		colNames = new Vector();
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("출판사");
		colNames.add("가격");
		
		table = new JTable(rowData, colNames);
		
		jtf_bookid = new JTextField();
		jtf_bookname = new JTextField();
		jtf_publisher = new JTextField();
		jtf_price = new JTextField();
		
		JScrollPane jsp = new JScrollPane(table);
		
		p_jtf.setLayout(new GridLayout(4,2));
		p_jtf.add(new JLabel("도서번호"));
		p_jtf.add(jtf_bookid);
		p_jtf.add(new JLabel("도서명"));
		p_jtf.add(jtf_bookname);
		p_jtf.add(new JLabel("출판사"));
		p_jtf.add(jtf_publisher);
		p_jtf.add(new JLabel("가격"));
		p_jtf.add(jtf_price);
		
		JButton btn_list = new JButton("목록");
		JButton btn_search = new JButton("검색");
		JButton btn_add = new JButton("추가");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		p_btn.add(btn_list);
		p_btn.add(btn_search);
		p_btn.add(btn_add);
		p_btn.add(btn_update);
		p_btn.add(btn_delete);
		
		p_center.setLayout(new BorderLayout());
		p_center.add(p_jtf, BorderLayout.CENTER);
		p_center.add(p_btn, BorderLayout.SOUTH);
		
		
		
		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rowData.clear();
				
				String keyword = jtf_publisher.getText();
				
				list = dao.searchBook(keyword);
				
				for(BookVO d : list) {
					
					Vector v = new Vector();
					
					v.add(d.getBookid());
					v.add(d.getBookname());
					v.add(d.getPublisher());
					v.add(d.getPrice());
					
					rowData.add(v);
				}
				table.updateUI();
			}});
	}
	
	public static void main(String[] args) {
		new BookTest();
	}

}
