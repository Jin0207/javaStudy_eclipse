package com.sist.exam01;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add("사과");
		set.add("수박");
		set.add("딸기");
		System.out.println(set);
		System.out.println(set.size());
		
		set.add("바나나");
		set.add("사과"); //중복이어서 false임, 추가안됨
		set.add("귤");
		set.add("라");
		System.out.println(set);
		System.out.println(set.size());
	
		set.remove("라");
		System.out.println(set);
		System.out.println(set.size());
	}

}
