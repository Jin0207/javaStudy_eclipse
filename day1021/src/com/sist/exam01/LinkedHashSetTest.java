package com.sist.exam01;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		LinkedHashSet set = new LinkedHashSet();
		set.add("사과");
		set.add("수박");
		set.add("딸기");
		System.out.println(set);
		set.add("바나나");
		set.add("사과");
		System.out.println(set);
		//중복허용안하지만 데이터의 순서는 기억함
	}

}
