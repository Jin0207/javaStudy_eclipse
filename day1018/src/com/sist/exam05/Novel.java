package com.sist.exam05;

public class Novel extends Book {
	
	public Novel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Novel(String number, String title, String author) {
		super(number, title, author);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLateFees(int days) {
		// TODO Auto-generated method stub
		return days * 300;
	}

}
