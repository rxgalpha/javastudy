package tcpdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

class TcpClient2{
    public static void main(String[] args){
        System.out.println("client start...");
        Socket s;
		try {
			s = new Socket("127.0.0.1",10005);
	        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	        RecvThread rt = new RecvThread(br);
	        rt.start();
	        //主线程 将用户输入信息发往服务端
	        String sendDataStr=null;
	        while((sendDataStr=input.readLine())!=null){
	            if(sendDataStr.equals("bye")){
	                break;
	            }
	            bw.write(sendDataStr);
	            bw.newLine();
	            bw.flush();
	        }
	        bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
//子线程 接收服务端返回信息
class RecvThread extends Thread{
	BufferedReader br;
	public RecvThread(BufferedReader br) {
		this.br = br;
	}
	@Override
	public void run() {
        String receiveDataStr=null;
        try {
			while((receiveDataStr=br.readLine())!=null){
			    if(receiveDataStr.equals("bye")){
			        break;
			    }
			    System.out.println(receiveDataStr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}