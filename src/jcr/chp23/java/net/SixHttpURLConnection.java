package jcr.chp23.java.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SixHttpURLConnection {

	public static void main(String[] args) throws IOException {
		
		//make a url to get a link
		URL hp = new URL("http://www.google.com");
		URLConnection hpcon = hp.openConnection();
		//this is a connection subclass for the open connection
		HttpURLConnection hpurlcon = (HttpURLConnection) hp.openConnection();
		
		//display request method
		System.out.println("Request method is " + hpurlcon.getRequestMethod());
		
		System.out.println("Response code is " + hpurlcon.getResponseCode());
		
		System.out.println("Response message is "+ hpurlcon.getResponseMessage());
		
		//get header on the httpconnection url which returns a map
		//of a string and a list that contains strings too
		Map<String, List<String>> hdrMap = hpurlcon.getHeaderFields();
		
		//set key on our map object 
		Set<String> hdrField = hdrMap.keySet();
		
		System.out.println("\nHere is the header: ");
		
		//loop our set and copy it as string
		//format it to k and invoke k on our map and pass our set
		for(String k: hdrField) {
			System.out.println("Key: " + k + " value: \t"  + hdrMap.get(k));
		}
		
		

	}

}
