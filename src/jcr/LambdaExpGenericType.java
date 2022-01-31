package jcr;

interface SomeFunc<T>{
	T func(T t);							//our lambda exp is going to take a meth func that takes a 
												//return type generic and returns a return type generic
}
public class LambdaExpGenericType {

	public static void main(String[] args) {
		
		//first declaration for string
		SomeFunc<String> reverse = (s)-> {
			String result = null;
			
			for(int i = s.length()-1; i>=0; i--)					//s has been inferred from the lambda exp as stirng
				 result += s.charAt(i);
			
			return result;
		};
		
		System.out.println("The reverse of Qurbatuallah is : " + reverse.func("Qurbatullah"));
		
		//another declaration for int
		SomeFunc<Integer>	factorial = (n) -> {
			int result = 1;
			
			for(int i = 1; i <= n; i++) {
				result = result * i;
			}
			
			return result;
		};
		
		System.out.println("The factorial of 10 is : "+ factorial.func(10));
		System.out.println("The factorial of 10 is : "+ factorial.func(4));
		
		for (int i = 0; i<10; i ++ )
			System.out.println(i);

		
	}

}
