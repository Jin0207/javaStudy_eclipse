package com.sist.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {

	public static void main(String[] args) {
		try {
			//��ü������ �Է��� ���� ObjectInputStream�� ��ü����
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/lim.stu"));
			Student lim = (Student)ois.readObject();
			
			System.out.println("�̸�: " + lim.getName());
			System.out.println("����: " + lim.getKor());
			System.out.println("����: " + lim.getEng());
			System.out.println("����: " + lim.getMath());
			ois.close();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}

}
