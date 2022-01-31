package jcr;
//with static import : used to import the static members of a class or interface
//help call static without involving the class name
//to calculate the hypothenus of a triangle
//power and sqrt are static methods hence called with their class name


import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.System.out;


public class StaticHypot2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double side1, side2;
		double hypot;
		side1 = 3.0;
		side2 = 4.0;
		
		hypot = sqrt(pow(side1, 2) + pow(side2,  2)) ;
		System.out.println("Given sides of lengths " + side1 + " and"	+ side2 +
				" the hypotenuse is "	+ hypot);
		
		out.println("importing static of system allows us to use it without refereing to "
				+ " System.out.println in full");
	}

}
