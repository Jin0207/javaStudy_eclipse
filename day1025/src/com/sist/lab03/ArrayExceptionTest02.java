package com.sist.lab03;

public class ArrayExceptionTest02 {

	public static void main(String[] args) {
		MyArray array = new MyArray();
		System.out.println("�迭�� ���: " + array.getAverage());
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