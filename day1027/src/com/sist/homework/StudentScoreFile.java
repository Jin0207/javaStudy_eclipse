package com.sist.homework;

import java.io.FileWriter;

public class StudentScoreFile {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("c:/myData/studentscore.txt");
			fw.write("ȫ�浿,100,80,90");
			fw.close();
		
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
		System.out.println("������ �����Ͽ����ϴ�.");
	}

}
