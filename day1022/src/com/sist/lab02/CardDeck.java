package com.sist.lab02;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	//�����ڿ��� CardDeck�� ��������� deck�� 52���� ī�带 ����� ������
	public CardDeck() {
		
		String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		//��ø�ݺ����� �̿��Ͽ� 52���� ī�带 �����Ͽ� deck�� ��´�
		for(int i = 0; i < suit.length; i++) {
			for(int j = 0; j < number.length; j++) {
				deck.add(new Card(suit[i], number[j]));
			}
		}
		/*
		System.out.println(deck);
		shuffle();
		System.out.println(deck);
		Card c1 = deal();//52���� 0��°ī�� �̰� �ְ� ����
		System.out.println(c1);
		System.out.println(deck);
		Card c2 = deal(); //51���� 0��° ī�带 �̾Ƽ� �ְ� deck���� ����
		System.out.println(c2);
		System.out.println(deck);
		*/
	}
	//52���� ī�带 �����ִ� �޼���
	public void shuffle() {
		Collections.shuffle(deck);
	} 
	//ī�带 �̴� �޼���
	//remove(int index) ����� �����Ҹ� ��ȯ�Ѵ�.
	public Card deal() {
		return deck.remove(0);
	}
}
