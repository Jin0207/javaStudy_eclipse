package com.sist.homework;

import java.io.FileWriter;

public class StudentScoreFile {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("c:/myData/studentscore.txt");
			fw.write("홍길동,100,80,90");
			fw.close();
		
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		System.out.println("파일을 생성하였습니다.");
	}

}
