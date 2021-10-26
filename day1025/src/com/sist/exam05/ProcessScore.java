package com.sist.exam05;

import java.util.ArrayList;

public class ProcessScore {
	private double avg;
	
	public ProcessScore() {
		
	}
	public ProcessScore(ArrayList<Double> score) throws IllegalScore{
		super();
	
		double tot = 0;
		for(double data : score) {
			tot += data;
			if(data < 0) {
				throw new IllegalScore("������ 0���� ���� �� �����ϴ�.");
			}
		}
		
		setAvg(tot / score.size());	
	}
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
