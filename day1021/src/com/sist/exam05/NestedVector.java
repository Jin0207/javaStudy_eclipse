package com.sist.exam05;

import java.util.ArrayList;
import java.util.Vector;

public class NestedVector {

	public static void main(String[] args) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		
		Vector<String> row1 = new Vector<String>();
		row1.add("ȫ�浿");
		row1.add("����");
		row1.add("010-1324-1234");
		
		Vector<String> row2 = new Vector<String>();
		row2.add("ȫ����");
		row2.add("���ֵ�");
		row2.add("010-1554-1235");
		
		Vector<String> row3 = new Vector<String>();
		row3.add("ȫ����");
		row3.add("������");
		row3.add("010-1884-1888");
		
		list.add(row1);
		list.add(row2);
		list.add(row3);
		/*
		for(ArrayList<String> row : list) {
				System.out.println(row);
		}
		*/
		System.out.println("�̸�\t�ּ�\t��ȭ");
		for(Vector<String> row:list) {
			for(String data : row) {
				System.out.print(data + "\t");
			}
			System.out.println();
		}
	}

}
