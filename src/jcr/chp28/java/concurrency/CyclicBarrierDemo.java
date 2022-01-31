package jcr.chp28.java.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//this class is a thread that only prints barrier Reached!
class BarAction implements Runnable{
	
	public void run() {
		System.out.println("Barrier Reached!");
	}
}

//this class will take an obj of cyclic barrier and a name
//it prints the name and waits
class MyThread2 implements Runnable {
	CyclicBarrier cbar;
	String name;
	
	MyThread2(CyclicBarrier cbar, String name){
		this.cbar = cbar;
		this.name = name;
	}
	
	public void run()	{
		System.out.println(name);
		
		try {
			cbar.await();
		} catch(BrokenBarrierException exc) {
			System.out.println(exc);
		} catch(InterruptedException exc) {
			System.out.println(exc);
		}
	}
}


public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction()); 
		//creating a cyclic barrier obj that will take 3 threads and runs them
		//when its done, it calls bar action which runs the string in its class
		
		System.out.println("Starting");
		
		new Thread(new MyThread2(cb, "A")).start();
		new Thread(new MyThread2(cb, "B")).start();
		new Thread(new MyThread2(cb, "C")).start();
//		Thread th =  new Thread2("C"); 
//		th.start();
		
		//starting our set of threads to be used in the cyclic barrier to control synchronization
		//each thread is implementing our My thread2 class which is runnable
		//my thread2 takes an object of cyclic barrier and a string
		//it prints the name of the string and waits
		

	}

}
