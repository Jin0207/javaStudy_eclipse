package com.sist.exam02;

import java.util.Random;
import java.util.TreeSet;
//set�� �̿��Ͽ� �ζ� 5�� ����
public class AutoLottoUsingSet {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		Random r = new Random();
		int cnt = 5;
		
		for(int i = 0; i < cnt; i++) {
			while(set.size() < 6) {
				set.add(r.nextInt(45) + 1);
			}
			System.out.print(set);
			System.out.println();
			set.clear();
		}
	}

}
