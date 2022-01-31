package jcr.chp20.java.utility;

import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) {
		
//		BitSet( )
//		BitSet(int size)
		
		BitSet bits1 = new BitSet(16);
		BitSet bits2 = new BitSet(16);
		
		//set some bits
		for(int i = 0; i<16; i ++ ) {
			if((i%2)==0) 
				bits1.set(i);  		//loop 0 to 16 ; if i is divisible by 2, put in bits1
			
			if((i%5) != 0)
				bits2.set(i);		//loop 0 to 16, if index is not divisible by 5 put in bit 2
		}
		
		System.out.println("Initial pattern in bits1: ");
		System.out.println(bits1);
		
		System.out.println("\nInitial pattern in bits2: ");
		System.out.println(bits2);
		
		//And bits
		bits2.and(bits1);
		System.out.println("\nbits2 AND bits1: ");
		System.out.println(bits2);
		
		//or bits
		bits2.or(bits1);
		System.out.println("\nbits2 OR bits1: ");
		System.out.println(bits2);
		
		//XOR BITS
		bits2.xor(bits1);
		System.out.println("\nbits2 XOR bits1: ");
		System.out.println(bits2);

	}

}
