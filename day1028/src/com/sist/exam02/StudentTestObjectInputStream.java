package com.sist.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {

	public static void main(String[] args) {
		try {
			//객체단위로 입력을 위한 ObjectInputStream의 객체생성
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/lim.stu"));
			Student lim = (Student)ois.readObject();
			
			System.out.println("이름: " + lim.getName());
			System.out.println("국어: " + lim.getKor());
			System.out.println("영어: " + lim.getEng());
			System.out.println("수학: " + lim.getMath());
			ois.close();
			
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
