package com.sist.exam02;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add("���"); //0*100 "���"
		list.add("����"); //0*100: "���", 0*200 �� 0*200: "����"
		list.add("����");
		System.out.println(list);
		
		list.add("����");
		list.add("���");
		System.out.println(list);
		
	}

}
