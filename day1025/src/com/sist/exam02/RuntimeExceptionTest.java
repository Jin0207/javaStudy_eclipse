package com.sist.exam02;

public class RuntimeExceptionTest {

	public static void main(String[] args) {
		int[] a = {10, 20, 30};
		System.out.println(a[3]);
		
		//�迭�� �ε��� ������ �Ѵ� ���ܰ� �߻�������
		//ArrayIndexOutOfBoundsException�� RuntimeException�� �ļ��̹Ƿ�,
		//����ڰ� ����ó���� ���� �ʾƵ�, �ڹٰ� ����ó���� ���־� �������� �����ϴ�
		//�ʿ��ϴٸ�, ���������� ����ڰ� ����ó���� �� ���� �ִ�.
	}

}
