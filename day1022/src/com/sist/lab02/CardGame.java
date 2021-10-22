package com.sist.lab02;

public class CardGame {

	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		
		deck.shuffle();
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		for(int i = 0; i < 7; i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());
		}
		
		p1.showCards();
		p2.showCards();
		
		if(p1.isOnePair() != 0) {
			System.out.printf("player1�� ������Դϴ�. �����: %d%n",p1.isOnePair());
		}else {
			System.out.println("Player1�� ���� �ƴմϴ�.");
		}
		
		if(p2.isOnePair() != 0) {
			System.out.printf("player2�� ������Դϴ�. �����: %d%n",p2.isOnePair());
		}else {
			System.out.println("Player2�� ���� �ƴմϴ�.");
		}
		
	}

}
