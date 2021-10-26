package com.sist.lab02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Player {
	String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	//��(���)�� �̷�� ī������ ��� ���� ���� ����Ʈ ����
	public TreeSet<Integer> pairList = new TreeSet<Integer>();
	//�������ϴ� ����ڰ� CardDeck���� ���� ī�带 �ϳ��� ������ ���� ����Ʈ
	private ArrayList<Card> list = new ArrayList<Card>();
	
	public Player(){
		int value = 2;
		for(int i = 0; i < number.length; i++) {
			map.put(number[i], value++);
		}
	}
	//ī�带 �Ű������� �޾� ����Ʈ������
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int pairProcess(String player) {
		int n = 0;
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n = map.get(list.get(i).getNumber());
					
					//���� �̷�� ���ڸ� pairList�� ����
					pairList.add(n);
				}
			}
		}
		Iterator<Integer> iter = pairList.iterator();
		//pairList�� 3���϶�, ū�� �ΰ��� �̾ƿ���
		if(pairList.size() == 3) {
			System.out.println(player + "�� ����� �Դϴ�.");
			iter.next();//0��¹�� ��Ҹ� ������ ����
			n = iter.next() + iter.next();
		}else if(pairList.size() == 2){
			System.out.println(player + "�� ����� �Դϴ�.");
			n = iter.next() + iter.next();
		}else if(pairList.size() == 1){
			System.out.println(player + "�� ����� �Դϴ�.");
			n = iter.next();
		}
		return n;
	}

	//�����
	public TreeSet<String> isTwoPair() {
		TreeSet<String> pair = new TreeSet<String>();
		
		for(int i = 0; i < list.size(); i++) {//
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					pair.add(list.get(i).getNumber());
				}
			}
		}
		return pair;
	}
	//Ʈ����
	public String isTriple() {
		String n = "";
		for(int i = 0; i < list.size(); i++) {
			int count = 0;
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					count++;
					if(count == 2) {
						return n = list.get(i).getNumber();
					}
				}
			}
		}
		return n;
	}
	//Ǯ�Ͽ콺
	public TreeSet<String> isFullHouse() {
		TreeSet<String> list = new TreeSet<String>();
		if(isTriple() != "" && isTwoPair().size() == 2) {
			return isTwoPair();
		}
		return list;
	}
	//1��:royal flush
	public boolean isRoyalFlush() {
		ArrayList<String> royal = new ArrayList<String>(Arrays.asList("10","Jack", "Queen", "King", "Ace"));
		Collections.sort(royal);
		TreeSet<String> player = new TreeSet<String>();
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < royal.size(); j++) {
				if(list.get(i).getNumber().equals(royal.get(j))) {
					player.add(list.get(i).getNumber());
				}
			}
		}
		System.out.println(player);
		return player.containsAll(royal);
	}
	
	//�����ִ� ī�带 ���
	public void showCards() {
		System.out.println(list);
	}
}
