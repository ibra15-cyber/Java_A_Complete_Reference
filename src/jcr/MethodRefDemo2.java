package jcr;
/**
 * We got an interface with an uncompleted method to be implemented by 
 * 				1. class
 * 				2. lambda expression
 * 
 * we have a class MyStringOps that returns a reverse of of a string passed
 * 
 * we got a static method that take a lambda expression implementing our interface and a string to pass through
 * 
 * 
 * 
 * **/

interface StringFunc3{																												
	String func(String n);
}

//a class that could be the code in our lambda expression
class MyStringOps{
	
	String strReverse(String str) {
		String result = " ";
		
		for(int i = str.length() -1; i>=0; i--){
			result = result + str.charAt(i);
		}
		return result;
	}
}
public class MethodRefDemo2 {
	
	//passing MyStringOps as sf is completing the lambda exp
	//with interface type StringFunc3
	//We went on to invoke the call inside this fujnction sf.func(s)
	//but we needed to pass a string usually so we used another parater to be
	//entered when we call static method stringOp
	static String stringOp(StringFunc3 sf, String s) {
		return sf.func(s);
	}
	

	public static void main(String[] args) {
		
		//we created a string inStr
		String inStr = "Lambda add power to Java";
		String outStr;
		
		//creating an obj of MyStringOps that takes 
		MyStringOps strOps = new MyStringOps();
		
		//passing strOps::strReverse as an argument of the first type
		//just like MyStringOps::strReverse
		//which is StringFunc sf and inStr of String s
		//strOps.strReverse is the normal way to call strReverse
		//but here its diff because strOps::strReverse returns String 
		//hence can be used with our interface
		outStr = stringOp(strOps::strReverse, inStr); 
		
		//the above is same as: implementing the functional interface
		//this is an anonymous lambda expression
		//of the type block
		StringFunc3 strOps2 = (a) -> {
			String result = "";
			
			for(int i = a.length()-1; i>=0; i--) {
				result += a.charAt(i);
			}
			return result;
		};
		
		
		System.out.println("Original string: " + inStr);
		System.out.println("String reversed: " + outStr);
		
		System.out.println("My invention: " + strOps2.func(inStr));
		

	}

}
