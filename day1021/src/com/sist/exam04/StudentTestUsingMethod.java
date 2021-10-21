package com.sist.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestUsingMethod {
	private String name;
	private String addr;
	private String phone;
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("'1': �߰�, '2': �˻�, '3': ����, '4': ������, '5': ��λ���, '0': ���� / �Է����ּ���");
		System.out.print("�޴��� �����ϼ���: ");
	}
	
	public static void insertStudent(ArrayList<Student> list) {
		String name, addr, phone;
		System.out.println("�л��� �̸��� �Է��ϼ���");
		name = sc.next();
		System.out.println("�л��� �ּҸ� �Է��ϼ���");
		addr = sc.next();
		System.out.println("�л��� ��ȭ��ȣ�� �Է��ϼ���");
		phone = sc.next();
		list.add(new Student(name, addr, phone));
	}
	
	public static void searchStudent(ArrayList<Student> list) {
		String name;
		System.out.println("�˻��� �л��� �̸��� �Է��ϼ��� :");
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
			System.out.println("ã���� �ϴ� �л� " + name + "�� �����ϴ�.");
		}
	}
	
	private static void deleteStudent(ArrayList<Student> list) {
		System.out.println("������ �л��� �̸��� �Է��ϼ���");
		String name = sc.next();
		int i;
		int length = list.size(); 
		// �����ϱ� �� ����Ʈ�� ũ�⸦ �̸� ������ ����, �����ϸ� ũ�Ⱑ �����Ǵϱ�
		for(i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				break;
			}
		}
		
		if(i < length) {
			System.out.println(name + " �л��� ������ �����Ͽ����ϴ�.");						
		}else {
			System.out.println(name + " �л��� ������ �����ϴ�.");												
		}
		
	}
	
	private static void printAll(ArrayList<Student> list) {
		if(list.isEmpty()) {
			System.out.println("����� �л��� ������ �����ϴ�.");
		}else {
			for(Student student : list) {
				System.out.println(student);
			}
		}
		
	}
	
	private static void allDeleteStudent(ArrayList<Student> list) {
		list.clear();
		System.out.println("�л����� ������ ��� �����Ͽ����ϴ�.");
		
	}
	//������(readability)�� ���Ͽ�
	//main�޼��� ���� ��� ������ ��ó���� �� ���� �ֱ⺸�ٴ�
	//������ ��ü���� ��ó������ �޼���� �������ְ�
	//main�޼��忡�� �ش� �޼��带 ȣ�����ش�.
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
