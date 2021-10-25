package com.sist.homework;

import java.util.ArrayList;
import java.util.Iterator;

public class Exam07 {

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>();
		
		for(int i = 0; i <= 5; i++) {
			list.add(i + 1.5);
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("\t%.2f", list.get(i));
		}
		System.out.println();
		
		for(double v : list) {
			System.out.printf("\t%.2f", v);
		}
		System.out.println();
		
		Iterator<Double> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.printf("\t%.2f",iter.next());
		}
		
	}

}
