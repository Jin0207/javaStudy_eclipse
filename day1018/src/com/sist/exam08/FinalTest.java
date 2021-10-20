package com.sist.exam08;
class Person{
	public String name = "홍길동";
	public final String addr = "서울시 마포구 서교동";
	
	/*바꾸지도 못하는 final키워드가 붙은 것들은
	 * 굳이 객체마다 따로 메모리를 확보할 필요가 없다.
	 * 그래서 final멤버는 static으로 만드는 것이 좋다.
	 */
}
public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person father = new Person();
		Person son = new Person();
		
		son.name = "홍두식";
		System.out.println(father.name + ", " + father.addr);
		System.out.println(son.name + ", " + son.addr);
	}

}
