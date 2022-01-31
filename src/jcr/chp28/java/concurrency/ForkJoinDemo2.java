package jcr.chp28.java.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction{
	int seqThreshold;
	double[] data;
	int start, end;
	
	Transform(double[] data, int start, int end, int seqThreshold){
		this.data  = data;
		this.start = start;
		this.end = end;
		this.seqThreshold = seqThreshold;
	}
	
	protected void compute() {
		if((end-start) <seqThreshold) {
			for (int i = start; i<end; i++) {
				if((data[i] % 2 )== 0) //if even
					data[i]  = Math.sqrt(data[i]); //find sqrt
				else
					data[i] = Math.cbrt(data[i]); 
			}
		} else { //if the end - start isnt less than our threshold
			int middle = (start + end )/2; //divide into two
			
			invokeAll(new Transform(data, start, middle, seqThreshold),
					new Transform(data, middle, end, seqThreshold)); //then invoke all
		}
	}
}
public class ForkJoinDemo2 {

	public static void main(String[] args) {
		int pLevel;
		int threshold;
		
		if(args.length != 2) {
			System.out.println("Usage: FJExperiment parallelism threshold");
			return;
		}
		
		pLevel = Integer.parseInt(args[0]);
		threshold = Integer.parseInt(args[1]);
		
		long beginT, endT;
		
		ForkJoinPool fjp = new ForkJoinPool(pLevel);
		
		double[] nums = new double[1000000];
		for (int i = 0; i< nums.length; i++)
			nums[i] = (double ) i;
		
		Transform task = new Transform(nums, 0, nums.length, threshold);
		
		beginT = System.nanoTime(); //we get the time before it starts
		
		fjp.invoke(task);
		
		endT = System.nanoTime(); //we return the time after it ends
		
		System.out.println("Level of parallelism: " + pLevel);
		System.out.println("Sequential threshold: " + threshold);
		System.out.println("Elapsed time: " + (endT - beginT) + " ns");
		System.out.println();
		
		

	}

}
