package jcr.chp23.java.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FourUrlTogetAwebPage {

	public static void main(String[] args) throws IOException {
		
		URL hp = new URL("http://www.HerbSchildt.com/WhatsNew");
		
		System.out.println("Protocol: " + hp.getProtocol());
		System.out.println("Port: " + hp.getPort());
		System.out.println("Host: " + hp.getHost());
		System.out.println("File: " + hp.getFile());
		System.out.println("Ext: " + hp.toExternalForm());
		System.out.println(hp.getUserInfo());
		
		
		
		System.out.println(hp.openConnection());
		
		System.out.println(hp.openConnection().getHeaderFields());
	}

}
