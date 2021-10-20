package com.sist.exam03;

import java.util.StringTokenizer;

public class StringTestSplit {

	public static void main(String[] args) {
		String data = "ȫ�浿/20/����/010-1234-5678";
		String[] arr = data.split("/");
		//String�� split�޼��� "/"���� �߶� �迭�� ��ȯ��
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
