/**
 * 
 */
package jcr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author dell
 *
 */
public class BRReadLine {

	/**
	 * 
	 */
	public BRReadLine() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter lines of texts and stop to quit");
		
		String str;
		do {
			str = br.readLine();
			System.out.println(str);
		}while(!str.equals("stop")); //string uses .equals for comparison

		
	}

}
