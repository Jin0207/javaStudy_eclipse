package com.sist.exam01;

import java.io.FileWriter;

public class StudentTest {

	public static void main(String[] args) {
		Student lim = new Student("임상이", 99, 88, 100);
		
		//Student 객체인 lim의 정보를 파일로 기록하고 싶음
		// 문자단위 출력 ( 이름, 국어, 영어, 수학 을 모두 문자열로 만들어 차례로 출력)
		try {
			FileWriter fw = new FileWriter("c:/myData/lim.txt");
			
			fw.write(lim.getName()+",");
			// 문자열로 만들어 출력
			fw.write(lim.getKor() + ",");
			fw.write(lim.getEng() + ",");
			fw.write(lim.getMath() + "");
			
			fw.close();
			System.out.println("파일을 생성하였습니다.");
	
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		// 바이트단위로 출력 ( 객체를 통째로 출력)
	}

}
