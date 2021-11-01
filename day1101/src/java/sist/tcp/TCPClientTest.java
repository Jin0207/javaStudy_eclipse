package java.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientTest {

	public static void main(String[] args) {
		//1. 서버측에 통신요청을 한다.
		try {
			Socket socket = new Socket("localhost", 9001);
			
			//2. 연결되었을 때 소켓을 통하여 데이터를 주고받을 스트림 생성
			InputStream is = socket.getInputStream();
			
			//3. 소켓을 통하여 데이터를 주고받는다.
			for(int i = 0; i <= 10; i++) {
				int n = is.read();
				System.out.println("서버로부터 수신된 데이터: " + n);
				Thread.sleep(1000);
			}
			
			//4. 닫아준다.
			is.close();
			socket.close();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		
	}

}
