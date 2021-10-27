package com.sist.inputoutput;

import java.io.FileInputStream;

public class InputStreamTest {

	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("c:/myData/output.txt");
			
			while(true) {
				int data = file.read();
				if(data == -1) {
					break;
				}
				System.out.println((char)data);
			}
			file.close();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
