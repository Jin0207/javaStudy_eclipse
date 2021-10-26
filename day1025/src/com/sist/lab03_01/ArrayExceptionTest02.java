package com.sist.lab03_01;

public class ArrayExceptionTest02 {

	public static void main(String[] args) {
		try {
			MyArray array = new MyArray();
			System.out.println("�迭�� ���: " + array.getAverage());
		}catch (NegativeArraySizeException e) {
			System.out.println("���ܹ߻�: �迭�� ũ��� ������ �� �� �����.");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("���ܹ߻�: �迭�� �ε��� ������ �Ѿ����ϴ�.");
		}catch (NullPointerException e) {
			System.out.println("���ܹ߻�: �迭�� �������� �ʾҽ��ϴ�.");
		}catch(ArithmeticException e) {
			System.out.println("���ܹ߻�: �迭�� �����Ͱ� �ϳ��� �����.");
		}
	}

}
/*
	ArithmeticException �߻���?
		�迭�� ũ�Ⱑ 0�� ��
	NegativeArraySizeException?
		�迭�� ũ�Ⱑ ������ ��
	ArrayIndexOutOfBoundsException?
	 �迭�� ũ�⺸�� �� ���� �ε�����Ҹ� �������� �Ҷ�	
	NullPointerException?
	 �迭 ������ �����ϱ⸸ �ϰ� �迭�� ���������ʰ� ����Ϸ����� �� - -�迭�� ũ�Ⱑ ���̳ʽ��̰ų� �迭�� ����������
*/