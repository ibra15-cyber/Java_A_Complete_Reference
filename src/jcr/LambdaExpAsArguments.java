package jcr;

interface StringFunc2{
	String func (String n);
}

public class LambdaExpAsArguments {
	
	static String stringOp(StringFunc2 sf, String s) {
		return sf.func(s);														//when called, take the string s and compute the lambda exp and return
	}
	//just like NumericTest2 isFactor = (n) -> (n%2) == 0; but encapsulating both the fn and string
	//StringFunc2 sf = (str) -> str.toUpperCase();
	//sf.func("String");
	//so here we encapsulate both the lambda expre def and the parameter in another static function stringOp
	
	public static void main(String[] args) {
		String inStr = "Lambdas add power to Java";
		String outStr;
		
		System.out.println("Here is input string: "+ inStr);
		
		//capitalize  and one parameter lambda
		//so first thing: str is passed and lambda changes it to capital
		//stringOp takes both the both sf and invokes its interface
		//then pass inStr into sf.func(inStr);
		outStr = stringOp( (str) -> str.toUpperCase(), inStr );		    //any string we pass return its upper; since we are passing inStr its upper will be returned by just the lambda exp
																										//also stringop that takes a lambda expression and a string is supposed to pass the string in the lambda exp and re
																										//return sf.func(s) ie. the lambda expression and invoke func meth which takes s; and that string here is inStr
		System.out.println("The string is upper: "+ outStr); 			//will capitalize outStr ie 
		
		//Copy string in to result; also block lambda
		outStr = stringOp( (str) -> {
			String result = "";
			
			for(int i = 0; i<str.length(); i ++)
				if((str.charAt(i) != ' '))
					result += str.charAt(i);
			
			return result;
		}, inStr);
		
		System.out.println("using block lambda ex: " + outStr);    //going back and copying everything from inStr into our static meth
		
		//reverse for the string parameter
		//defined separately and passed into as argument
		StringFunc2 reverse = (str) ->{
			String result = "";
			
			for(int i = str.length()-1; i>=0; i--)				
				result += str.charAt(i);
			return result;
		};
		
		System.out.println("Without using the redundant static method the string reversed: " + reverse.func(inStr)); //reserve only
		System.out.println("The string reversed after our lambda is expressed as reverse: " + stringOp(reverse, inStr));
		
		
		
		
	}

}
