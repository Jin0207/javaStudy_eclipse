package com.sist.exam05;

import java.util.ArrayList;

public class ProcessScoreTest {

	public static void main(String[] args) {
		ArrayList<Double> score = new ArrayList<Double>();
		score.add(50.0);
		score.add(50.5);
		score.add(95.7);
		score.add((double)0);
		//score.add(-55.5);
		
		try {
			ProcessScore ps = new ProcessScore(score);
			System.out.printf("����� %.2f �Դϴ�", ps.getAvg());			
		}catch(IllegalScore p) {
			System.out.println("���ܹ߻�: " + p.getMessage());
		}
		
	}

}
