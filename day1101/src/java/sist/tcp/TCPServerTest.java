package java.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest {
	
	public static void main(String[] args) {
		Random r = new Random();
		//1. ServerSocket�� �����Ѵ�
		try {
			ServerSocket server = new ServerSocket(9001);
			
			//3. Ŭ���̾�Ʈ�� ���������� ����Ѵ�
			Socket socket = server.accept();
			System.out.println("Ŭ���̾�Ʈ�� ������ �����Ͽ����ϴ�.");
			
			//4. �����͸� �ְ���� ��Ʈ���� �����Ѵ�.
			OutputStream os = socket.getOutputStream();
			
			//5. ��Ʈ���� ���ؼ� �����͸� �ְ�޴´� 
			for(int i = 1; i <= 10; i++) {
				int n = r.nextInt(100);
				
				Thread.sleep(200);
				os.write(n);
			}
			
			//6. ��� �� �ݾ��ش�.
			os.close();
			socket.close();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}

}
