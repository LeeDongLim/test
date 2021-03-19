package EX001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MySocketClient {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.74", 1234); // 소켓 서버에 접속
			consoleLog("socket 서버에 접속 성공!");

			// OutputStream - 클라이언트에서 Server로 메세지 발송
			OutputStream os = socket.getOutputStream();
			// socket의 OutputStream 정보를 OutputStream out에 넣은 뒤
			PrintWriter writer = new PrintWriter(os, true);
			// PrintWriter에 위 OutputStream을 담아 사용
			
			// 클라이언트에서 서버로 메세지 보내기
			writer.println("CLIENT TO SERVER");
			
			// InputStream - Server에서 보낸 메세지 클라이언트로 가져옴
			InputStream is = socket.getInputStream();
			// socket의 InputStream 정보를 InputStream in에 넣은 뒤
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			// BufferedReader에 위 InputStream을 담아 사용

			System.out.println(reader.readLine());
			// 서버에서 온 메세지 확인
			System.out.println("CLIENT SOCKET CLOSE");
			socket.close(); // 소켓 종료

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
                if( socket != null && !socket.isClosed() ) {
                	socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	private static void consoleLog(String log) {
        System.out.println("[server " + Thread.currentThread().getId() + "] " + log);
    }

}