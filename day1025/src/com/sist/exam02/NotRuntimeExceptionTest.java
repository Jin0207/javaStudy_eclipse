package com.sist.exam02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotRuntimeExceptionTest {

	public static void main(String[] args) {
		//FileWriter fw = new FileWriter("hello.txt");
		/*
			Unhandled exception type IOException
			--> 예외가 발생하니깐 try catch 해서 예외처리해야한다
		 */

		try {
			//파일 생성
			FileWriter fw = new FileWriter("c:/work_day1025/hello.txt");
			/*
			 * 예외 발생
			 * FileWriter fw = new FileWriter("c:/work_day1026/hello.txt");
			 * 예외발생: c:\work_day1026\hello.txt (지정된 경로를 찾을 수 없습니다)
			 */
			
			//파일 안의 내용을 작성

			fw.write("안녕하세요");
			//파일을 작성하면 닫아주어야한다.
			fw.close();
		}catch(IOException e) {
			System.out.println("예외발생: " + e.getMessage());
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
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
/*
 * public int read() throws IOException
 * Reads a single character.
 * Returns:
 * The character read, or -1 if the end of the stream has been reached
 * 더 이상 읽을 것이 없다면 -1을 반환하고 그렇지 않다면 문자의 유니코드를 반환
*/