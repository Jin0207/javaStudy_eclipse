package com.sist.homework;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class WordFrequency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<String> data = new TreeSet<String>();
		
		System.out.print("������ �Է��ϼ���: ");
		String[] word = sc.nextLine().split(" ");
		
		for(int i = 0; i < word.length; i++) {
			data.add(word[i]);
		}
		
		int[] count = new int[data.size()];
		ArrayList<String> wordList = new ArrayList<String>(data);

		for(int i = 0; i < word.length; i++) {
			for(int j = 0; j < wordList.size(); j++) {
				if(wordList.get(j).contains(word[i])) {
					count[j]++;
				}
			}
		}
		
		System.out.println("\t����\t����");
		
		for(int i = 0; i < wordList.size(); i++) {
			System.out.println("\t" + wordList.get(i) + "\t" + count[i]);
		}
		
	}

}
