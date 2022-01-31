package jcr;

interface NumericFunc{
	int func(int n);
}

public class LambdaExpBlockFactorial {

	public static void main(String[] args) {

		NumericFunc factorial = (n) -> {				//factorial is adding up to a number from 1
			int result  = 1;
			
			for (int i = 1; i <= n; i ++)						//from 1 to a number multiply everything
				result = i*result;
			
			return result;
		};
		
		System.out.println("The factorial of 4 is : "  + factorial.func(4));
		System.out.println("The factorial of 6 is : "  + factorial.func(6));

	}

}
