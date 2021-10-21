package com.sist.exam01;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet data = new HashSet();
		data.add("사과");
		data.add("포도");
		data.add("수박");
		data.add("낑깡");
		
		System.out.println(data);
		//새로운 메모리가 아닌 기존 메모리에 배열요소를 추가할수잇음
		data.add("오렌지");
		data.add("사과");
		//중복 데이터는 담지 않음
		//데이터의 순서 유지하지 않음
		System.out.println(data);
	}

}
