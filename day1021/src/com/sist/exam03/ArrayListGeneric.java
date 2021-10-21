package com.sist.exam03;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListGeneric {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(100);
		list.add("홍길동");
		list.add(26.7);
		list.add(new Date());
		list.add(true);
		System.out.println(list);
		
		ArrayList<String> list2 = new ArrayList<String>();
		//list2.add(100); 제네릭을 하여 String타입만 담을 수 있음
		list2.add("홍길동");
		list2.add("유관순");
		list2.add("강감찬");
		System.out.println(list2);
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add(100 + "");
		list3.add("홍길동");
		list3.add("유관순");
		list3.add("강감찬");
		System.out.println(list3);
		
		/*
		 ArrayList<int> list4 = new ArrayList<int>();
		 리스트에 담을 수 있는 자료형을 정수형으로 제한하기 위하여
		 기본자료형인 int를 사용할 수 없고
		 기본자료형 int를 객체만들어주는 Integer클래스사용
		*/
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(50);
		list4.add(30);
		list4.add(20);
		System.out.println(list4);
	}

}
