package com.sist.homework;

import java.io.FileReader;
import java.util.StringTokenizer;

public class PrintTotalAndAverage {
	public static void main(String[] args) {
		String str = "";
		try {
			FileReader fr = new FileReader("c:/myData/studentscore.txt");
			
			while(true) {
				int data = fr.read();
				
				if(data == -1) {
					break;
				}//end if
				
				str += (char)data;
			}//end while
			
		}catch (Exception e) {
			System.out.println("¿¹¿Ü¹ß»ý: " + e.getMessage());
		}//end catch


		String[] data = str.split(",");
		int tot = 0;
		double avg;

		for(int i = 1; i < data.length; i++) {
			tot += Integer.parseInt(data[i]);
		}
		avg = tot / 3;
		System.out.printf("ÇÐ»ý %sÀÇ ÃÑÁ¡: %d, Æò±Õ: %.2f",data[0],tot,avg);
		
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
			
			System.out.println("ÇÐ»ý: " + name);
			System.out.println("ÃÑÁ¡: " + tot);
			System.out.println("Æò±Õ: " + avg);
		}//end while
	*/
	}

}
