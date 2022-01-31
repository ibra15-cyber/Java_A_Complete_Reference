package jcr.chp23.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		
		//gets the host associated with same name but here its the local machine
		InetAddress address = InetAddress.getLocalHost(); 
		System.out.println(address);
		
		//here our address is gettign by name a site
		address = InetAddress.getByName("www.HerbSchildt.com");
		System.out.println(address);
		
		//declare a constructor for inet addrees associated with a site
		//then go on and print all those sites
		InetAddress[] sw = InetAddress.getAllByName("www.nba.com");
		for(int i=0; i<sw.length; i++)
			System.out.println(sw[i]);
		

	}

}
