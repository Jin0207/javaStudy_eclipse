package com.sist.exam01;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add("���");
		set.add("����");
		set.add("����");
		System.out.println(set);
		System.out.println(set.size());
		
		set.add("�ٳ���");
		set.add("���"); //�ߺ��̾ false��, �߰��ȵ�
		set.add("��");
		set.add("��");
		System.out.println(set);
		System.out.println(set.size());
	
		set.remove("��");
		System.out.println(set);
		System.out.println(set.size());
	}

}
