package com.sist.exam08;
class Person{
	public String name = "ȫ�浿";
	public final String addr = "����� ������ ������";
	
	/*�ٲ����� ���ϴ� finalŰ���尡 ���� �͵���
	 * ���� ��ü���� ���� �޸𸮸� Ȯ���� �ʿ䰡 ����.
	 * �׷��� final����� static���� ����� ���� ����.
	 */
}
public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person father = new Person();
		Person son = new Person();
		
		son.name = "ȫ�ν�";
		System.out.println(father.name + ", " + father.addr);
		System.out.println(son.name + ", " + son.addr);
	}

}
