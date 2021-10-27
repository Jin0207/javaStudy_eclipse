package com.sist.inputoutput;

import java.io.FileOutputStream;

public class OutPutStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream file = new FileOutputStream("c:/myData/output.txt");
			file.write(65);
			file.write(66);
			
			file.close();
			System.out.println("파일을 생성하였습니다.");
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
