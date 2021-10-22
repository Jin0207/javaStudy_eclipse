package com.sist.lab02;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	//생성자에서 CardDeck의 멤버변수인 deck에 52장의 카드를 만들어 담을것
	public CardDeck() {
		
		String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		//중첩반복문을 이용하여 52개의 카드를 생성하여 deck에 담는다
		for(int i = 0; i < suit.length; i++) {
			for(int j = 0; j < number.length; j++) {
				deck.add(new Card(suit[i], number[j]));
			}
		}
		/*
		System.out.println(deck);
		shuffle();
		System.out.println(deck);
		Card c1 = deal();//52장중 0번째카드 뽑고 주고 제거
		System.out.println(c1);
		System.out.println(deck);
		Card c2 = deal(); //51장중 0번째 카드를 뽑아서 주고 deck에서 제거
		System.out.println(c2);
		System.out.println(deck);
		*/
	}
	//52개의 카드를 섞어주는 메서드
	public void shuffle() {
		Collections.shuffle(deck);
	} 
	//카드를 뽑는 메서드
	//remove(int index) 지우고 지운요소를 반환한다.
	public Card deal() {
		return deck.remove(0);
	}
}
