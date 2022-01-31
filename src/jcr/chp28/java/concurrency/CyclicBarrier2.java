package jcr.chp28.java.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class BarAction2 implements Runnable{
	
	public void run() {
		System.out.println("Barrier Reached!");
	}
}

//takes an object of a cyclic barrier and a string
//prints the string and pause the cyclic barrier object
class MyThread3 implements Runnable {
	CyclicBarrier cbar;
	String name;
	
	MyThread3(CyclicBarrier cbar, String name){
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



public class CyclicBarrier2 {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction2());
		
		System.out.println("Starting");
		
		new Thread(new MyThread3(cb, "A")).start();
		new Thread(new MyThread3(cb, "B")).start();
		new Thread(new MyThread3(cb, "C")).start();
		new Thread(new MyThread3(cb, "X")).start();
		new Thread(new MyThread3(cb, "Y")).start();
		new Thread(new MyThread3(cb, "Z")).start();
//		Thread th =  new Thread2("C");
//		th.start();
		//so because we started 6 my thread classes,
		//the first 3 will prints then our action of calling the bar action will execute
		//followed by the next three
	}

}

