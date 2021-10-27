package com.sist.inputoutput;

import java.io.FileReader;

public class ReadFile {

	public static void main(String[] args) {
		//아까 생성한 c:/myData/hello.txt파일의 내용을 읽어와
		//화면에 출력 해 봅시다.
		
		try {
			FileReader fr = new FileReader("c:/myData/hello.txt");
			while(true) {
				int data = fr.read();
				
				if(data == -1) {
					break;
				}
				
				System.out.print((char)data);
			}
			fr.close();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
