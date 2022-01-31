package jcr;

interface NumericTest{
	boolean test(int n);
}

public class LambdaExpWithPara1 {

	public static void main(String[] args) {
		
		NumericTest isEven = (n) -> (n%2)==0;		//take an int n if n%2 is zero return true 
	
		if(isEven.test(10))
			System.out.println("10 is even");
		
		//! will make condition true hence will run
		if(!isEven.test(9))
			System.out.println("9 is not even"); //this wont print bc condition isnt met
		
		
		NumericTest ispositive= (n) -> (n%2)>= 0;	
		if(ispositive.test(1))
			System.out.println(" 1  is non negative"); 		//this wont print == condition not met
		
		if(!ispositive.test(-1))
			System.out.println("-1  is non negative");
		

	}

}
