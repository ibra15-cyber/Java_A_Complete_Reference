package jcr.chp28.java.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class SqrtTransform extends RecursiveAction{
	final int seqThreshold = 1000; //processing time 
	double[] data;
	int start;
	int end;
	
	SqrtTransform(double[] data, int start, int end){
		this.data = data;
		this.start = start;
		this.end = end;
	}
	
	protected void compute() { 	//this is starting point of recursive action which will not return a result, recursive task does return a result
		
		if((end - start) <seqThreshold) { //if end  -start is less than 1000
			for (int i = start; i<end; i++) { //start from start and end at end -1 index increment
				data[i] = Math.sqrt(data[i]	);  //each index value = its square root
			}
		} else { //but if the subtraction of end and start isnt less than 1000
			int middle = (start + end)/2; //find the mid point
			
			invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
		} //invoke all the 2 tasks
	}
}
public class ForkJoinDemo {

	public static void main(String[] args) { 
		ForkJoinPool fjp = new ForkJoinPool(); //defining obj of pool (default)
//		ForkJoinPool fjp = ForkJoinPool.commonPool();  //this too could have been used
		
		double[] nums = new double[100000];	//our list to be passed
		
		for(int i = 0; i< nums.length; i ++) //traversing our list
			nums[i] = (double) i ; //convert each index value to double 
		
		System.out.println("A portion of original sequence: ");
		
		for(int i = 0; i<10; i++) {
			System.out.println(nums[i] + " "); //return the initial list here using 0 to 9 as double
		}
		System.out.println();
		
		SqrtTransform task = new SqrtTransform(nums, 0, nums.length); //obj of our class sqrt transform
		
		fjp.invoke(task); //invoking the task in the pool
//		task.invoke();//this could have done exactly what the above is doing 
		
		System.out.println("A portion of the transformed sequence (to four decimal places):	");
		for(int i = 0; i< 10; i++)
			System.out.format("%.4f ", nums[i]); //format the values with 4 decimal places
		
		System.out.println();

	}

}
