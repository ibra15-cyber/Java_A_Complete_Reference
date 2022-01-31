/**
 * 
 */
package jcr.chp19.java.collection;

import java.util.Arrays;

public class ArrayVSCollections {
	public static void main(String[]args) {
		
		//creating array
		int[] array = new int[10];
		for(int i = 0; i<10; i++)
			array[i] = -3*i;  //multiply indexes by -3
		
		System.out.print(Arrays.toString(array));
		
		System.out.println();
		
		System.out.print("original ontents: ");
		display(array);
		
		
		System.out.print("Sorted: ");
		Arrays.sort(array);
		display(array);
		
		//fill and display teh array
			
		System.out.print("After fill(): ");
		Arrays.fill(array, 2, 6, -1); //fill index 2 to 5 with -1
		display(array);
		
		//sort and display the array
		
		System.out.print("After sorting again: ");
		Arrays.sort(array);
		display(array);
		
		//binary search for -9
		System.out.print("The value -9 is at location ");
		int index = Arrays.binarySearch(array, -9); //use binary search it takes array and an element
		
		System.out.print(index);
		
		
		
//		System.out.println(Arrays.asList(ar).toString()); 
		 
		
		}
	static void display(int array[]) {
		for(int i : array)
			System.out.print(i + " ");
		
		System.out.println();
	}
}