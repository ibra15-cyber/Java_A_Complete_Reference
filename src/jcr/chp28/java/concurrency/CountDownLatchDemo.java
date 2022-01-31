package jcr.chp28.java.concurrency;

import java.util.concurrent.CountDownLatch;

class MyThread4 implements Runnable{
	CountDownLatch latch;
	
	MyThread4(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println(i);
			latch.countDown();
		}
	}
}


public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(5); 
		//number of events to occur is 5 but after making it 4, 
		//the whole program was synchronized until after done is printed
		//then the last one 4 prints finally
		//making it 45 takes a long time to print done
		//because the events are still running
		
		System.out.println("Starting");
		new Thread(new MyThread4(cdl)).start(); //shortcut to start our thread
		
		try {
			cdl.await();											//methods like this are in the try block
		} catch(InterruptedException exc) {
			System.out.println(exc);
		}
		
		System.out.println("Done");

	}

}