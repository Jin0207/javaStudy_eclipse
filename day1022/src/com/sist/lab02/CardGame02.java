package com.sist.lab02;

public class CardGame02 {

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
		
		int n1 = p1.pairProcess("player1");
		int n2 = p2.pairProcess("player2");
		
		if(n1 == n2) {
			System.out.println("ºñ°å½À´Ï´Ù.");
		}else if(n1 > n2) {
			System.out.println("player1ÀÇ ½Â¸®");
		}else {
			System.out.println("player2ÀÇ ½Â¸®");	
		}
	}

}
