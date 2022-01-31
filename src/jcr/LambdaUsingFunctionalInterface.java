package jcr;

import java.util.function.Function;

interface Facto{
	int func(int n);
}
public class LambdaUsingFunctionalInterface {

	public static void main(String[] args) {
		
		int ans;
		
//	...............................................mine......................................................
		Facto facto = (n) -> {
			int result = 1;
			for(int i  =1; i<=n; i++) {
				result = i*result;
			}
			return result;
		};
		
		ans = facto.func(4);
		System.out.println("Mine factorial is " + ans);
		
//		.................................................book's...............................................
		Function<Integer, Integer> factorial  = (n) -> {
			int result = 1;
			for(int i  =1; i<=n; i++) {
				result = i*result;
			}
			return result;
		};
		ans = factorial.apply(4);
		System.out.println("Book's: default factorial using function default is " + ans);

	}

}
