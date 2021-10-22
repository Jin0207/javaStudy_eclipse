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
			System.out.printf("player1은 원페어입니다. 원페어: %d%n",p1.isOnePair());
		}else {
			System.out.println("Player1은 원페어가 아닙니다.");
		}
		
		if(p2.isOnePair() != 0) {
			System.out.printf("player2은 원페어입니다. 원페어: %d%n",p2.isOnePair());
		}else {
			System.out.println("Player2은 원페어가 아닙니다.");
		}
		
	}

}
