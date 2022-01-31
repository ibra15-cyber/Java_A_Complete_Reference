package jcr;

interface NumericTest2{
	boolean test(int n, int d);
}

public class LambdaExpWithPara2 {

	public static void main(String[] args) {
		
		NumericTest2 isFactor = (n, d) -> (n%d) == 0;
		
		if(isFactor.test(10, 2))
			System.out.println("2 is a factor of 10");
		
		if(!isFactor.test(10, 3))
			System.out.println("3 is not factor of 10");			//wont print to do, use ! and negate your statement
	
		NumericTest2 greaterthan = (m, q) -> (m > q);
		
		if(greaterthan.test(10, 2))
			System.out.println("10 is greater than 2");
		
		NumericTest2 add = (u, v) -> (u+v) >= 0;
		if (add.test(10, 34))
			System.out.println("u and v are greater than zero");
	}

}
