package com.sist.exam05;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] arr = new Book[4];
		arr[0] = new Novel("N1234", "재미있는 자바", "최현호");
		arr[1] = new Novel("N1234", "재미있는 자바", "최현호");
		if(arr[0].equals(arr[1])) {
			System.out.println("동일한 도서입니다.");
		}else {
			System.out.println("동일한 도서가 아닙니다.");
		}
		arr[2] = new Poet("P1234", "자바와 함께", "김지현");
		if(arr[1].equals(arr[2])) {
			System.out.println("동일한 도서입니다.");
		}else {
			System.out.println("동일한 도서가 아닙니다.");
		}
		arr[3] = new ScienceFiction("S1234", "신비한 자바", "김수연");
		
		for(Book book: arr) {
			System.out.println(book);
			System.out.println("연체료: " + book.getLateFees(2));
			System.out.println("===========================");
		}
	}
	
}
