package com.sist.inner;

public class A {
	private String title = "Hello";
	
	public void pro() {
		System.out.println("A Ŭ������ pro�޼ҵ�");
		
		// �̳�Ŭ������ ��������� �ٷ� ������ �� ����
		// System.out.println(year);
		
		//�����Ϸ��� ��ü�� �����ϰ� ��ü�� ���ؼ� �����ؾ��Ѵ�.
		B b = new B();
		System.out.println(b.year);
		
		//�̳�Ŭ������ �̷������� ����ҷ��� ����
		b.test();
	}
	
	//Ŭ���� ���� Ŭ���� -- inner class
	// �ٸ������� BŬ������ �ʿ䰡 ��� �̳�Ŭ������ ����
	class B{
		public int year = 2021;
		public void test() {
			System.out.println("B Ŭ������ test�޼ҵ�");
			
			//outterŬ������ ����� �����Ӱ� ����
			System.out.println(title);
			title = "hi";
			System.out.println(title);
			
		}// end test()
		
	}// end B class
	
	public static void main(String[] args) {
		A a = new A();
		a.pro();
		
		// �Ʒ��� ���� �ϴ� ���� �幰��
		//A.B ib = new A.B();
		
	}
}// end A
