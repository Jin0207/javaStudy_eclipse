package co.sist.file;

import java.io.File;

public class FileDeleteTest {

	public static void main(String[] args) {
		//c:/myData/���ɰ��.txt ������ �����ϴ� ���α׷� �ۼ�
		File file = new File("c:/myData/���ɰ��.txt");
		
		file.delete();
		System.out.println("�����Ͽ����ϴ�.");
	}

}
