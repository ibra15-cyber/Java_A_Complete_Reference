package jcr;

interface StringFunc{
	String func(String n);
}

public class LambdaExpBlockReverse {

	public static void main(String[] args) {
		
		StringFunc reverse = (s) -> {
			String result = "";
			
			for(int i = s.length()-1; i >=0; i --) 							//s.length() returns length of string s. so -1 is like getting actual size
				result += s.charAt(i);											//concatenate result with each index starting from the last to the first
			
			return result;
		};
		
		System.out.println("The reverse func for Qurbatuallah is: " + reverse.func("Qurbatullah"));

	}

}
