package jcr.chp23.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SevenServerCreationDataGram{
	
	public static int serverPort = 998;
	public static int clientPort = 999;
	public static int buffer_size = 1024;
	public static DatagramSocket ds;
	public static byte[] buffer = new byte[buffer_size];
	
	public static void TheServer() throws UnknownHostException, IOException	 {
		int pos = 0;
		while(true) {
			int c = System.in.read();
			System.out.println("print c " + c);
			switch(c) {
			
			case -1:
				System.out.println("Server Quits.");
				
				ds.close();
				return;
				
			case '\r':
				break;
			
			case '\n':
				ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), 
						clientPort));
				pos=0;
				break;
			
			default:
				buffer[pos++] = (byte) c;
			}
		}
	}
	
	public static void TheClient() throws IOException {
		
		while(true) {
			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
			ds.receive(p);
			System.out.println(new String(p.getData(), 0, p.getLength()));
			
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		if(args.length==1) {
			
			ds = new DatagramSocket(serverPort);
			TheServer();
		} else {
			ds = new DatagramSocket(clientPort);
			TheClient();
		}
		
		

	}

}
