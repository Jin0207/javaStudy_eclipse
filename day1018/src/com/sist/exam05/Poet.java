package com.sist.exam05;

public class Poet extends Book {
	
	public Poet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poet(String number, String title, String author) {
		super(number, title, author);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLateFees(int days) {
		// TODO Auto-generated method stub
		return days * 200;
	}

}
