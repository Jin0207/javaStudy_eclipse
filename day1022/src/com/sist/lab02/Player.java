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
	//쌍(페어)을 이루는 카드목록을 담아 놓기 위한 리스트 생성
	public TreeSet<Integer> pairList = new TreeSet<Integer>();
	//게임을하는 경기자가 CardDeck으로 부터 카드를 하나씩 가져와 담을 리스트
	private ArrayList<Card> list = new ArrayList<Card>();
	
	public Player(){
		int value = 2;
		for(int i = 0; i < number.length; i++) {
			map.put(number[i], value++);
		}
	}
	//카드를 매개변수로 받아 리스트에담음
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int pairProcess(String player) {
		int n = 0;
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n = map.get(list.get(i).getNumber());
					
					//쌍을 이루는 숫자를 pairList에 담음
					pairList.add(n);
				}
			}
		}
		Iterator<Integer> iter = pairList.iterator();
		//pairList가 3개일때, 큰값 두개만 뽑아오기
		if(pairList.size() == 3) {
			System.out.println(player + "는 투페어 입니다.");
			iter.next();//0번쨔ㅐ 요소를 꺼내서 버려
			n = iter.next() + iter.next();
		}else if(pairList.size() == 2){
			System.out.println(player + "는 투페어 입니다.");
			n = iter.next() + iter.next();
		}else if(pairList.size() == 1){
			System.out.println(player + "는 원페어 입니다.");
			n = iter.next();
		}
		return n;
	}

	//투페어
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
	//트리플
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
	//풀하우스
	public TreeSet<String> isFullHouse() {
		TreeSet<String> list = new TreeSet<String>();
		if(isTriple() != "" && isTwoPair().size() == 2) {
			return isTwoPair();
		}
		return list;
	}
	//1위:royal flush
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
	
	//갖고있는 카드를 출력
	public void showCards() {
		System.out.println(list);
	}
}
