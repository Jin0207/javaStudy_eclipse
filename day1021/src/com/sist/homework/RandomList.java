package com.sist.homework;

import java.util.ArrayList;
import java.util.Random;

public class RandomList {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static Random r = new Random();

	public static int get() {
		return r.nextInt(50 + 1); // 1 ~ 50
	}
	
	public static void add(int data) {
		list.add(data);
	}
	
	public static int select(int size) {
		return list.get(r.nextInt(size));
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			add(get());
		}
		System.out.println(list);
		System.out.println(select(list.size()));
		
	}
}
