package jcr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEditor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String[] strArr = new String[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter a text to be put into an array;. Stop to quit");
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = br.readLine();  //each index should occupy a readline
			
			if(strArr[i].equals("stop")) {
				break;
			}
		}
		
		//get input 
		for (int i = 0; i <strArr.length; i++) {
			System.out.println(strArr[i]);
			
			if(strArr[i].equals("stop")) {
				break;
			}
			
		}

	}

}
