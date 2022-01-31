/**
 * 
 */
package jcr;

/**
 * not working: program was supposed to support the loop
 *
 */
public class AssertDemo2 {
	static int val = 3;
	
	//return an int
	static int getnum()	{
		return val--;
	}

 static void main(String[] args) {
		// TODO Auto-generated method stub
	 
	 int n = 0;
	 for (int i =0; i< 10; i++) {
		 assert(n=getnum()) > 0;
		 System.out.println("n is "  + n);
	 }
	}

}
