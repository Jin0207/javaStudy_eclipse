package com.sist.exam02;
//���α׷� ���� �� �ΰ��� ������ ���޹޾� ������ �� ����� ����ϴ� ���α׷� �ۼ�
public class DivTestException {

	public static void main(String[] args) {
			try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int div = a / b;
			System.out.println("���: " + div);
		}catch(ArithmeticException a) {
			System.out.println("0���� ���� �� �����.");
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("�������� �ΰ��� ���� �Է��ϼ���");
		}catch(NumberFormatException n) {
			System.out.println("�������� �Է����ּ���.");
		}
	}

}
