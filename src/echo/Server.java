package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.118", 10001));
		
		System.out.println("<서버시작>");
		System.out.println("==================================================");
		
		
		//반복
		while(true) {
			System.out.println("[연결을 기다리고 있습니다.]");
			Socket socket = serverSocket.accept();
			Thread thread = new ServerThread(socket);
			thread.start();
			//System.out.println("[클라이언트가 연결되었습니다.]"); 상관없음
		}

		//serverSocket.close();
		
	}

}
