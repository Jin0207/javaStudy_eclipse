package com.sist.exam03;

import java.util.StringTokenizer;

public class StringTestSplit {

	public static void main(String[] args) {
		String data = "홍길동/20/서울/010-1234-5678";
		String[] arr = data.split("/");
		//String의 split메서드 "/"으로 잘라서 배열로 반환해
		for(String s : arr) {
			System.out.println(s);
		}
		
		System.out.println("------------------------------");
		StringTokenizer st =new StringTokenizer(data, "/");
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			System.out.println(str);
		}
	}

}
