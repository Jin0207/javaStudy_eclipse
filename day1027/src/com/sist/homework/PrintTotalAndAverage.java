package com.sist.homework;

import java.io.FileReader;
import java.util.StringTokenizer;

public class PrintTotalAndAverage {
	public static void main(String[] args) {
		String str = "";
		
		try {
			//텍스트 파일의 내용을 컴퓨터메모리로 읽어들이기 위하여 FileReader클래스를 이용
			//FileReader의 생성자는 "예외"를 갖고있기때문에 예외처리해야한다.
			FileReader fr = new FileReader("c:/myData/studentscore.txt");

			
			while(true) {
				//파일로부터 한글자씩 읽어들이는 read()
				//문자의 정수값을 반환, 파일의 끝에 도달하면 -1을 반환
				int data = fr.read();
				
				if(data == -1) {
					break;
				}//end if
				
				str += (char)data;
			}//end while
			
			fr.close();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}//end catch
		
		//split은 분리한 데이터들을 문자열 배열로 반환
		String[] arr = str.split(",");
		int tot = 0;
		double avg;

		for(int i = 1; i < arr.length; i++) {
			tot += Integer.parseInt(arr[i]);
		}
		avg = tot / 3;
		System.out.printf("학생 %s의 총점: %d, 평균: %.2f", arr[0], tot, avg);
		
		/*
		StringTokenizer data = new StringTokenizer(str, ",");
		int n = data.countTokens() - 1;
		
		while (data.hasMoreTokens()) {
			String name = data.nextToken();
			int tot = 0;
			double avg;
			
			for(int i = 1; i <= 3; i++) {
				tot += Integer.parseInt(data.nextToken());
			}// end for
			
			avg = (double)tot / n;
			
			System.out.println("학생: " + name);
			System.out.println("총점: " + tot);
			System.out.println("평균: " + avg);
		}//end while
	*/
	}

}
