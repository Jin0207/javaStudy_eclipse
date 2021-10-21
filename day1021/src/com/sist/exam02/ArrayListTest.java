package com.sist.exam02;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("사과");
		list.add("딸기");
		list.add("망고");
		System.out.println(list);
		
		list.add("포도");
		list.add("사과");
		System.out.println(list);
		//list는 중복을 허용하며 입력된 순서대로 출력해준다.
	}

}
