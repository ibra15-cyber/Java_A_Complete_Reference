package jcr.chp28.java.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread7 implements Runnable{
	String name;
	CountDownLatch latch;
	
	MyThread7(CountDownLatch latch, String name){
		this.name = name;
		this.latch = latch;
	}
	
	public void run() {
		
		for(int i = 0; i<5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}

public class ExcuterDemo {

	public static void main(String[] args) {
		
		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2= new CountDownLatch(5);
		CountDownLatch cd3= new CountDownLatch(5);
		CountDownLatch cd4= new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);
		//although 2 thread pools are meant to run
		//all threads will run with two at any given time
		
		System.out.println("Starting");
		
		es.execute(new MyThread7(cd1, "A"));
		es.execute(new MyThread7(cd2, "B"));
		es.execute(new MyThread7(cd3, "C"));
		es.execute(new MyThread7(cd4, "D"));
		
		try {
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		}catch(InterruptedException exc) {
			System.out.println(exc);
		}
		
		es.shutdown();
		System.out.println("Done");
		
		

	} 

}
