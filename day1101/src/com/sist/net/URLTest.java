package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			// ���ͳݻ��� ������ü ����
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			
			//�� ������ ������ �����ϱ� ���Ͽ� ��Ʈ���� ����
			InputStream is = url.openStream();
			
			//�� ���� �о���� byte���� �迭�� ����
			byte[] data = new byte[100];
			
			// �� ���� ����ϱ� ���ؼ�
			// ��Ʈ���� ���� �о�� ���ڿ��� �� ��Ƴ��� ���� ����
			String str = "";
			
			while( is.read(data) != -1) {
				//String(byte[] bytes)
				str += new String(data, "utf-8");
			}
			
			System.out.println(str);
			
			// ��Ʈ���� ��� �� ������ �ݾ� �ش�.
			is.close();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	
	}
}
