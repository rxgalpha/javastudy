package com.rxg.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket ss;
		Socket socket;
		BufferedReader in;
		String line;
		try {
			ss = new ServerSocket(5888);
			socket = ss.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				line = in.readLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
