package java.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest {
	
	public static void main(String[] args) {
		Random r = new Random();
		//1. ServerSocket을 생성한다
		try {
			ServerSocket server = new ServerSocket(9001);
			
			//3. 클라이언트의 서버접속을 허용한다
			Socket socket = server.accept();
			System.out.println("클라이언트가 서버에 접속하였습니다.");
			
			//4. 데이터를 주고받을 스트림을 생성한다.
			OutputStream os = socket.getOutputStream();
			
			//5. 스트림을 통해서 데이터를 주고받는다 
			for(int i = 1; i <= 10; i++) {
				int n = r.nextInt(100);
				
				Thread.sleep(200);
				os.write(n);
			}
			
			//6. 사용 후 닫아준다.
			os.close();
			socket.close();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
