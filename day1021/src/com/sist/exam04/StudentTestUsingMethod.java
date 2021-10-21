package com.sist.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestUsingMethod {
	private String name;
	private String addr;
	private String phone;
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("'1': 추가, '2': 검색, '3': 삭제, '4': 모두출력, '5': 모두삭제, '0': 종료 / 입력해주세요");
		System.out.print("메뉴를 선택하세요: ");
	}
	
	public static void insertStudent(ArrayList<Student> list) {
		String name, addr, phone;
		System.out.println("학생의 이름을 입력하세요");
		name = sc.next();
		System.out.println("학생의 주소를 입력하세요");
		addr = sc.next();
		System.out.println("학생의 전화번호를 입력하세요");
		phone = sc.next();
		list.add(new Student(name, addr, phone));
	}
	
	public static void searchStudent(ArrayList<Student> list) {
		String name;
		System.out.println("검색할 학생의 이름을 입력하세요 :");
		name = sc.next();
		Student searchStudent = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				searchStudent = list.get(i);
				break;
			}
		}
		if(searchStudent != null) {
			System.out.println(searchStudent);
		}else {
			System.out.println("찾고자 하는 학생 " + name + "은 없습니다.");
		}
	}
	
	private static void deleteStudent(ArrayList<Student> list) {
		System.out.println("삭제할 학생의 이름을 입력하세요");
		String name = sc.next();
		int i;
		int length = list.size(); 
		// 삭제하기 전 리스트의 크기를 미리 변수에 저장, 삭제하면 크기가 변동되니깐
		for(i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				break;
			}
		}
		
		if(i < length) {
			System.out.println(name + " 학생의 정보를 삭제하였습니다.");						
		}else {
			System.out.println(name + " 학생의 정보는 없습니다.");												
		}
		
	}
	
	private static void printAll(ArrayList<Student> list) {
		if(list.isEmpty()) {
			System.out.println("출력할 학생의 정보가 없습니다.");
		}else {
			for(Student student : list) {
				System.out.println(student);
			}
		}
		
	}
	
	private static void allDeleteStudent(ArrayList<Student> list) {
		list.clear();
		System.out.println("학생들의 정보를 모두 삭제하였습니다.");
		
	}
	//가독성(readability)을 위하여
	//main메서드 안의 모든 복잡한 일처리를 다 집어 넣기보다는
	//각각의 구체적인 일처리들을 메서드로 정의해주고
	//main메서드에서 해당 메서드를 호출해준다.
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		while(true) {
			printMenu();
			int menu = sc.nextInt();
			
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
				case 1: insertStudent(list); break;
				case 2: searchStudent(list); break;
				case 3: deleteStudent(list); break;
				case 4: printAll(list); break;
				case 5: allDeleteStudent(list); break;
			}
		}
		
	}

}
