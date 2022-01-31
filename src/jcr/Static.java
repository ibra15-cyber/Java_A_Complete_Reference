package jcr;
//with static import : used to import the statci members of a class or interface
//help call static without involving the class name
//to calculate the hypothenus of a triangle
//power and sqrt are static methods hence called with their class name
public class Static{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double side1, side2;
		double hypot;
		side1 = 3.0;
		side2 = 4.0;
		
		hypot = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2,  2)) ;
		System.out.println("Given sides of lengths " + side1 + " and"	+ side2 + " the hypotenuse is "	+ hypot);
	}

}
