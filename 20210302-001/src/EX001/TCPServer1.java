package EX001;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer1 {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    try {
      
      serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress("localhost", 10001));
      System.out.println("[Server] socket create complete!!");
      Socket socket = serverSocket.accept();
      InetSocketAddress isAdd = (InetSocketAddress)socket.getRemoteSocketAddress();
      System.out.println("[Server] client["+isAdd.getHostName() + "](PORT:" + isAdd.getPort() + ")"
                        +" connect ... accept complete!!");
      // 클라이언트 소켓으로 데이터를 보내기 위한 준비
      OutputStream os = socket.getOutputStream();
      
      String data = "소켓 프로그래밍 Socket !!!!!!!!!!!!!!!!!!!";
      // 인터넷으로 데이터를 보내기 위해 변환( UTF -> Byte[] )
      os.write( data.getBytes("UTF-8") );
      // os 가 사용하는 버퍼를 출력(네트워크)쪽으로 보내기(비움)
      os.flush();
      os.close();
      
      socket.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(serverSocket != null && serverSocket.isClosed() == false) {
        try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); }
      }
      
    }
    
    
  }

}
