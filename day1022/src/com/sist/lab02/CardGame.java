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
		
		if(p1.isTwoPair().size() == 2) {
			System.out.println("player1은 투페어입니다. 투페어: " + p1.isTwoPair());
		}else {
			System.out.println("player1은 투페어가 아닙니다.");
		}
		
		if(p2.isTwoPair().size() == 2) {
			System.out.println("player2은 투페어입니다. 투페어: " + p2.isTwoPair());
		}else {
			System.out.println("player2은 투페어가 아닙니다.");
		}
		
		if(!p1.isTriple().equals("")) {
			System.out.println("player1은 트리플입니다. 트리플: " + p1.isTriple());
		}else {
			System.out.println("player1은 트리플이 아닙니다.");
		}
		
		if(!p2.isTriple().equals("")) {
			System.out.println("player2은트리플입니다. 트리플: " + p2.isTriple());
		}else {
			System.out.println("player2은 트리플이 아닙니다.");
		}
		
		if(p1.isFullHouse().size() != 0) {
			System.out.println("player1은 풀하우스입니다." + p1.isFullHouse());
		}else {
			System.out.println("player1은 풀하우스가 아닙니다.");
		}
		if(p2.isFullHouse().size() != 0) {
			System.out.println("player2은 풀하우스입니다." + p2.isFullHouse());
		}else {
			System.out.println("player2은 풀하우스가 아닙니다.");
		}
		

		if(p1.isRoyalFlush()) {
			System.out.println("player1은 RoyalFlush");
		}else {
			System.out.println("player1은 RoyalFlush가 아닙니다.");
		}
		if(p2.isRoyalFlush()) {
			System.out.println("player2은 RoyalFlush");
		}else {
			System.out.println("player2은 RoyalFlush가 아닙니다.");
		}
	}

}
