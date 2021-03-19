package EX001;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TCPClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("[Client] 연결 요청");
			socket.connect(new InetSocketAddress("192.168.0.74", 10001));
			System.out.println("[Client] 연결 성공");
			
			OutputStream os = socket.getOutputStream();
			String data = "[Client]가 입장하였습니다.";
			os.write(data.getBytes("UTF-8"));
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					socket.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}

	}

}