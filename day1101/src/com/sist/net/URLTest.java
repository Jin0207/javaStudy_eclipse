package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			// 인터넷상의 문서객체 생성
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			
			//그 문서의 내용을 수집하기 위하여 스트림을 생성
			InputStream is = url.openStream();
			
			//한 번에 읽어들일 byte형의 배열을 만듦
			byte[] data = new byte[100];
			
			// 한 번에 출력하기 위해서
			// 스트림을 통해 읽어온 문자열을 다 모아놓을 변수 선언
			String str = "";
			
			while( is.read(data) != -1) {
				//String(byte[] bytes)
				str += new String(data, "utf-8");
			}
			
			System.out.println(str);
			
			// 스트림은 사용 후 무조건 닫아 준다.
			is.close();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	
	}
}
