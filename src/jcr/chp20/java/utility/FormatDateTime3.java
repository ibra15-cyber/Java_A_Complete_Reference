package jcr.chp20.java.utility;

import java.util.Formatter;

public class FormatDateTime3 {

	public static void main(String[] args) {
		
		//%n === \n 
		//%% ===\%
		Formatter fmt = new Formatter();
		fmt.format("Copying file%nTransfer is %d%% complete", 88);
		System.out.println(fmt);
		fmt.close();
		
		//System.out.printf("minimum field width specifier: %05d", 898.98080 );
	}

}
