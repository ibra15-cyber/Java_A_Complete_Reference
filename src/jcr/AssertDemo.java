package jcr;

//not working; supposed to run assert which runs until a condition is right or wrong

public class AssertDemo {
	
	static int val = 3;
	
	//return an integer
	static int getnum() {
		return val--;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n ;
		for (int i =0; i< 10; i ++) {
			n = getnum();
			assert n>0;
			System.out.println("n is 	" + n);		
		}
	}

	
}
