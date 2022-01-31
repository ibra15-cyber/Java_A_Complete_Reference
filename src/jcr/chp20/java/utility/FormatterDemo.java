package jcr.chp20.java.utility;

import java.util.Formatter;

public class FormatterDemo {

	public static void main(String[] args) {
		
//		Formatter( )
//		Formatter(Appendable buf)
//		Formatter(Appendable buf, Locale loc)
//		Formatter(String filename) throws FileNotFoundException
//		Formatter(String filename, String charset) throws FileNotFoundException, UnsupportedEncodingException
//		Formatter(File outF) throws FileNotFoundException
//		Formatter(OutputStream outStrm)
		
		
		Formatter fmt = new Formatter();
		fmt.format("formating %s is easy %d %f", "with java", 10, 98.6);
//		String str2 = fmt.toString();
		System.out.println(fmt);
		
		
		//another %f and %e
		Formatter fmt2 = new Formatter();
		
		for(double i=1.23; i<1.0e+6; i*=100) {
			fmt2.format("%f %e", i, i);
			System.out.println(fmt2);
		}
		fmt2.close();
		
		//%o octal %x hexadecimal
		Formatter fmt3 = new Formatter();
		System.out.println("the outcome of hex, oct, floating point using %a conversion: ");
		fmt3.format("Hex: %x, Oct: %o, FloatingPoint: %a", 196, 196, 512.0);
		System.out.println(fmt3);
		
		
			
		
		
		
		//mine worked
		String str = "me";
		int i = 123;
		double db = 23.34;
		
		System.out.printf("this is formated string %s , int %d and %f ", str, i, db);

	}

}
