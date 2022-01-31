/**
 * 
 */
package jcr;

/**
 * @author dell
 *
 */
interface MyNumber{
	double getVal();
}
public class LambdaExprWithoutPara {
	
	public static void main(String[] args) {
	
		//instead creating a class and implementing the interface
		//lambda expressions can do the same with lot ease
		//we never called it my its type name, neither does it have a functional name
		MyNumber myNum = () -> 123.45;
		System.out.println("A fixed value: "+ myNum.getVal());
		
		myNum = () -> Math.random()	 * 100;
		System.out.println("A random value: " + myNum.getVal());
		System.out.println("Another random value: " + myNum.getVal());


	}

}
