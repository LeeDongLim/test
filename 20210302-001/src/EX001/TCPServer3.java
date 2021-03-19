package EX001;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TCPServer3 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.74", 10001));
			System.out.println("[서버] 연결 대기중");

			Socket socket = serverSocket.accept();
			System.out.println("[서버] 연결중...");

			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println("[서버] 연결됨 from " + inetSocketAddress.getHostName() + ":" + inetSocketAddress.getPort());

			OutputStream os = socket.getOutputStream();
			String data2 = "접속성공! \r\n" + "\r\n";
			String data = "Wellcome java class! \r\n" + "\r\n" + "Glad to meet you :) \r\n"
					+ "See you next time... bye! \r\n";
			String data1 = "\r\n" + "프로그램을 종료합니다.";
			os.write(data2.getBytes("MS949"));
			os.write(data.getBytes("UTF-8"));
			os.write(data1.getBytes("MS949"));

			os.flush();
			os.close();

	InputStream is = socket.getInputStream();
	while (true) {
		byte[] butter = new byte[128];
		int readByteCount = is.read(butter);

		if (readByteCount < 0) {
			System.out.println("[Server] Client disconneted");
			is.close();
			socket.close();
			break;
		}
		String data3 = new String(butter, 0, readByteCount, "MS949");
		System.out.print(data3);
	}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null && serverSocket.isClosed())
				try {
					serverSocket.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}

	}

}
