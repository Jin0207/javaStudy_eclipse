package com.sist.exam06;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길똥");
		list.add("서울");
		list.add("010-1234-5678");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("이름", "홍길동");
		map.put("주소", "서울");
		map.put("전화", "010-1234-1234");
		
		//list로부터 주소를 출력하려면 인덱스로 접근
		System.out.println(list.get(1));
		//map으로붙터 주소를 출력하려면 key값으로 접근
		System.out.println(map.get("주소"));
	}

}
