package co.sist.file;

import java.io.File;

public class FileDeleteTest {

	public static void main(String[] args) {
		//c:/myData/점심고민.txt 파일을 삭제하는 프로그램 작성
		File file = new File("c:/myData/점심고민.txt");
		
		file.delete();
		System.out.println("삭제하였습니다.");
	}

}
