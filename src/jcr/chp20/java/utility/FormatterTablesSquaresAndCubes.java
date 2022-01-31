package jcr.chp20.java.utility;

import java.util.Formatter;

public class FormatterTablesSquaresAndCubes {

	public static void main(String[] args) {
		
		Formatter fmt;
		
		for(int i = 1; i <10; i++) {
			fmt = new Formatter();
			fmt.format("%4d %4d %4d", i, i*i, i*i*i); //move four spaces from the front
			System.out.println(fmt);
			fmt.close();
			
		}
		
		System.out.println("this wont work as we want");
		Formatter fmt2;
		for(int i = 1; i <10; i++) {
			fmt2 = new Formatter();
		//	fmt.format //move four spaces from the front
			System.out.printf("%4d %4d %4d", i, i*i, i*i*i);
			fmt2.close();
			
		}
		
		

	}

}
