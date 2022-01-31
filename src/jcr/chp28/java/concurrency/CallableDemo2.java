package jcr.chp28.java.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


class Sum implements Callable<Integer>{
	int stop;
	
	Sum(int stop){
		this.stop = stop;
	}
	
	public Integer call() {
		int sum = 0;
		for(int i = 1; i<=stop; i++) {
			sum += i;
		}
		return sum;
	}
}


class Hypot implements Callable<Double>{
	double side1;
	double side2;
	
	Hypot(double side1, double side2){
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public Double call() {
		return Math.sqrt((side1*side1) + (side2*side2));
	}
}

class Factorial implements Callable<Integer>{
	int stop;
	
	Factorial(int stop){
		this.stop = stop;
	}
	
	public Integer call() {
		int fact = 1;
		for (int i = 2; i<=stop; i++) {
			fact *= i;
		}
		return fact;
	}
}


public class CallableDemo2 {

	public static void main(String[] args) throws InterruptedException, TimeoutException {
		ExecutorService es = Executors.newFixedThreadPool(3);
		Future<Integer> f;
		Future<Double> f2;
		Future<Integer> f3;
		
		System.out.println("Starting");
		
		f = es.submit(new Sum(10));
		f2 = es.submit(new Hypot(3, 4));
		f3 = es.submit(new Factorial(5));
		
		try { //using a second form of get
			System.out.println(f.get(10, TimeUnit.MILLISECONDS));
			System.out.println(f2.get(10, TimeUnit.MILLISECONDS));
			System.out.println(f3.get(10, TimeUnit.MILLISECONDS));
		} catch(ExecutionException exc) {
			System.out.println(exc);
		} catch(TimeoutException exc) {
			System.out.println(exc);
		}
		
		es.shutdown();
		System.out.println("Done");

	}
	
	

}
