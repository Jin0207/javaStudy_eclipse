package com.sist.exam02;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add("»ç°ú"); //0*100 "»ç°ú"
		list.add("µþ±â"); //0*100: "»ç°ú", 0*200 ¤Ñ 0*200: "µþ±â"
		list.add("¸Á°í");
		System.out.println(list);
		
		list.add("Æ÷µµ");
		list.add("»ç°ú");
		System.out.println(list);
		
	}

}
