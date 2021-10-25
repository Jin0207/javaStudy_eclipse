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
		
		if(p1.isTwoPair().size() == 2) {
			System.out.println("player1�� ������Դϴ�. �����: " + p1.isTwoPair());
		}else {
			System.out.println("player1�� ���� �ƴմϴ�.");
		}
		
		if(p2.isTwoPair().size() == 2) {
			System.out.println("player2�� ������Դϴ�. �����: " + p2.isTwoPair());
		}else {
			System.out.println("player2�� ���� �ƴմϴ�.");
		}
		
		if(!p1.isTriple().equals("")) {
			System.out.println("player1�� Ʈ�����Դϴ�. Ʈ����: " + p1.isTriple());
		}else {
			System.out.println("player1�� Ʈ������ �ƴմϴ�.");
		}
		
		if(!p2.isTriple().equals("")) {
			System.out.println("player2��Ʈ�����Դϴ�. Ʈ����: " + p2.isTriple());
		}else {
			System.out.println("player2�� Ʈ������ �ƴմϴ�.");
		}
		
		if(p1.isFullHouse().size() != 0) {
			System.out.println("player1�� Ǯ�Ͽ콺�Դϴ�." + p1.isFullHouse());
		}else {
			System.out.println("player1�� Ǯ�Ͽ콺�� �ƴմϴ�.");
		}
		if(p2.isFullHouse().size() != 0) {
			System.out.println("player2�� Ǯ�Ͽ콺�Դϴ�." + p2.isFullHouse());
		}else {
			System.out.println("player2�� Ǯ�Ͽ콺�� �ƴմϴ�.");
		}
		

		if(p1.isRoyalFlush()) {
			System.out.println("player1�� RoyalFlush");
		}else {
			System.out.println("player1�� RoyalFlush�� �ƴմϴ�.");
		}
		if(p2.isRoyalFlush()) {
			System.out.println("player2�� RoyalFlush");
		}else {
			System.out.println("player2�� RoyalFlush�� �ƴմϴ�.");
		}
	}

}
