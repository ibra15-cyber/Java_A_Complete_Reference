package jcr;

import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintWriter pw = new PrintWriter(System.out, true);
		
		pw.println("This is a string"); //PrintWriter preferred to System.out in real application
		
		int i = -7;
		pw.println(i);
		
		double d = 4.5e-7;
		pw.println(d);
		
	}

}
