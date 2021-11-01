package java.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientTest {

	public static void main(String[] args) {
		//1. �������� ��ſ�û�� �Ѵ�.
		try {
			Socket socket = new Socket("localhost", 9001);
			
			//2. ����Ǿ��� �� ������ ���Ͽ� �����͸� �ְ���� ��Ʈ�� ����
			InputStream is = socket.getInputStream();
			
			//3. ������ ���Ͽ� �����͸� �ְ�޴´�.
			for(int i = 0; i <= 10; i++) {
				int n = is.read();
				System.out.println("�����κ��� ���ŵ� ������: " + n);
				Thread.sleep(1000);
			}
			
			//4. �ݾ��ش�.
			is.close();
			socket.close();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
		
	}

}
