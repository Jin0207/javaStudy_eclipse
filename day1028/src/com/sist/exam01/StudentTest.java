package com.sist.exam01;

import java.io.FileWriter;

public class StudentTest {

	public static void main(String[] args) {
		Student lim = new Student("�ӻ���", 99, 88, 100);
		
		//Student ��ü�� lim�� ������ ���Ϸ� ����ϰ� ����
		// ���ڴ��� ��� ( �̸�, ����, ����, ���� �� ��� ���ڿ��� ����� ���ʷ� ���)
		try {
			FileWriter fw = new FileWriter("c:/myData/lim.txt");
			
			fw.write(lim.getName()+",");
			// ���ڿ��� ����� ���
			fw.write(lim.getKor() + ",");
			fw.write(lim.getEng() + ",");
			fw.write(lim.getMath() + "");
			
			fw.close();
			System.out.println("������ �����Ͽ����ϴ�.");
	
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
		// ����Ʈ������ ��� ( ��ü�� ��°�� ���)
	}

}
