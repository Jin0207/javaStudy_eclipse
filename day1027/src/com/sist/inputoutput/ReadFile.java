package com.sist.inputoutput;

import java.io.FileReader;

public class ReadFile {

	public static void main(String[] args) {
		//�Ʊ� ������ c:/myData/hello.txt������ ������ �о��
		//ȭ�鿡 ��� �� ���ô�.
		
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
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}

}
