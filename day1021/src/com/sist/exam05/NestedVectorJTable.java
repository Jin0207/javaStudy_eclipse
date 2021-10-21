package com.sist.exam05;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NestedVectorJTable {

	public static void main(String[] args) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		
		Vector<String> row1 = new Vector<String>();
		row1.add("홍길동");
		row1.add("서울");
		row1.add("010-1324-1234");
		
		Vector<String> row2 = new Vector<String>();
		row2.add("홍길이");
		row2.add("제주도");
		row2.add("010-1554-1235");
		
		Vector<String> row3 = new Vector<String>();
		row3.add("홍독이");
		row3.add("강원도");
		row3.add("010-1884-1888");
		
		list.add(row1);
		list.add(row2);
		list.add(row3);
		
		Vector<String> colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("주소");
		colNames.add("전화");
		
		JTable table = new JTable(list, colNames);
		JScrollPane jsp = new JScrollPane(table);
		JFrame frame = new JFrame();
		frame.add(jsp);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

}
