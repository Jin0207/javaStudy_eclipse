package com.sist.exam02;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutputSstream {

	public static void main(String[] args) {
		Student lim = new Student("임상이", 99, 88, 100);
		// 바이트단위로 출력 ( 객체단위로 출력 )
		// 다른 txt파일과 구분하기위해 다른 확장자로 저장한다.
		try {
			//객체단위로 출력하기위한 ObjectOutputSream 객체 생성 -- FileOutputStreamdml 부모클래스
			//확장자는 텍스트파일이 아니기 때문에 .txt로 하지 않음
			//프로그램으 ㅣ성격에 맞도록 알맞게 확장자이름을 정해줌
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lim.stu"));
			//객체를 출력
			oos.writeObject(lim);
			
			oos.close();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
			
		}
	}

}
