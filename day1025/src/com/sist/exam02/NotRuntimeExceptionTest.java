package com.sist.exam02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotRuntimeExceptionTest {

	public static void main(String[] args) {
		//FileWriter fw = new FileWriter("hello.txt");
		/*
			Unhandled exception type IOException
			--> ���ܰ� �߻��ϴϱ� try catch �ؼ� ����ó���ؾ��Ѵ�
		 */

		try {
			//���� ����
			FileWriter fw = new FileWriter("c:/work_day1025/hello.txt");
			/*
			 * ���� �߻�
			 * FileWriter fw = new FileWriter("c:/work_day1026/hello.txt");
			 * ���ܹ߻�: c:\work_day1026\hello.txt (������ ��θ� ã�� �� �����ϴ�)
			 */
			
			//���� ���� ������ �ۼ�

			fw.write("�ȳ��ϼ���");
			//������ �ۼ��ϸ� �ݾ��־���Ѵ�.
			fw.close();
		}catch(IOException e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	/*
	 * public void write(String str) throws IOException
	 * public abstract void close() throws IOException
	 * 	getMessage()
	 *  : Returns the detail message string of this throwable.
	 */
		try {
			FileReader fr = new FileReader("c:/work_day1025/hello.txt");
			int ch;
			
			while((ch = fr.read()) != -1) {
				System.out.print( (char)ch );
			}
			
			fr.close();
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}

}
/*
 * public int read() throws IOException
 * Reads a single character.
 * Returns:
 * The character read, or -1 if the end of the stream has been reached
 * �� �̻� ���� ���� ���ٸ� -1�� ��ȯ�ϰ� �׷��� �ʴٸ� ������ �����ڵ带 ��ȯ
*/