package tcpdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

class TcpServer2 {
	public static void main(String[] args){
		System.out.println("server start...");
		try {
			ServerSocket ss = new ServerSocket(10005); // 不阻塞
			Socket s = ss.accept();// 阻塞
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			SendThread st = new SendThread(s);
			st.start();//开始心跳线程
			String receiveDataStr = null;
			//echo thread
			while ((receiveDataStr = br.readLine()) != null) {
				if (receiveDataStr.equals("bye")) {
					break;
				}
				String retString = "receive data:" + receiveDataStr;
//				System.out.println(retString);
				PrintWriter out = new PrintWriter(bw, true);
				out.println(retString);
				// bw.write(retString);//作用同上面2句
				// bw.write("\r\n");
				// bw.flush();
			}
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//心跳线程 每3秒打印系统时间
class SendThread extends Thread {
	Socket socket;
	public SendThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			while (true) {
				Thread.sleep(1000);
				out.println(new Date());
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		out.close();
	}
}
