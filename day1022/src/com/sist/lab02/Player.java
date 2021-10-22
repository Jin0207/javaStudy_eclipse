package com.sist.lab02;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	//게임을하는 경기자가 CardDeck으로 부터 카드를 하나씩 가져와 담을 리스트
	private ArrayList<Card> list = new ArrayList<Card>();
	//카드를 매개변수로 받아 리스트에담음
	public void getCard(Card card) {
		list.add(card);
	}
	//원페어인가? 원페어아니면 0출력
	public int isOnePair() {
		String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int value = 2;
		for(int i = 0; i < number.length; i++) {
			map.put(number[i], value++);
		}
		
		int n = 0;
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n = map.get(list.get(i).getNumber());
					return n;
				}
			}
		}
		return n;
	}
	//갖고있는 카드를 출력
	public void showCards() {
		System.out.println(list);
	}
}
