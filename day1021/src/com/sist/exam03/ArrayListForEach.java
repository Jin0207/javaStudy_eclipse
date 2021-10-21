package com.sist.exam03;

import java.util.ArrayList;

public class ArrayListForEach {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40};
		for(int data : arr) {
			System.out.println(data);
		}
		System.out.println("==========================");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		for(int data : list) {
			System.out.println(data);
		}
		System.out.println();
	}

}
