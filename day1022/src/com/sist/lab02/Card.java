package com.sist.lab02;

public class Card {
	private String suit;
	private String number;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Card(String suit, String number) {
		super();
		this.suit = suit;
		this.number = number;
	}

	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "[" + suit + ", " + number + "]";
	}
	
	
	
}
