package jcr.chp21.java.io;

public class PrintfDemo {

	public static void main(String[] args) {
		
		System.out.println("here are some numeric values  in different formates . \n");
		
		System.out.println("various integer formats: " );
		System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
		
		System.out.println();
		System.out.printf("\nDefault floating-point fomat:  %f", 1234567.123);
		System.out.printf("\nFloating-point with commas:  %,f", 1234567.123);
		System.out.printf("\nNegative floating-point default:  %,f", -1234567.123);
		System.out.printf("\nNegative floating-point option:  %,(f", -1234567.123);
		
		System.out.println();
		
		System.out.println("Line up positive and negative values:");
		System.out.printf("% ,.2f% ,.2f", 1234567.123, -1234567.123 );



		

	}

}
