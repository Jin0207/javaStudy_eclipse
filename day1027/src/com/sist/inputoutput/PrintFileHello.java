package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		//나의이름과, 나이를 파일로 기록해보자
		
		//문자단위의 출력을 위한 클래스는
		//Writer의 후손 중 파일 출력을 위한 FileWriter를 생성
		try {
			//정상동작을 위해서는 해당 폴더가 존재해야한다.
			FileWriter fw = new FileWriter("c:/myData/hello.txt");
			fw.write("나의 이름은 임상이이고\n");
			fw.write("나이는 20살 입니다.");
			
			//파일의 사용이 끝났으니 파일을 닫아주어야한다.
			//닫아주지 않으면 에러는 발생하진 않겠지만,
			//해당파일을 다른 곳에서 사용할 수 없게된다.
			fw.close();
			System.out.println("파일을 생성하였습니다.");
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
}
