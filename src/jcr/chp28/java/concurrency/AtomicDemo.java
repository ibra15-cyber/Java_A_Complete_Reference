package jcr.chp28.java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;


class Shared4{
	static AtomicInteger ai = new AtomicInteger(0); 
	//static because we will be calling an object of the class
	//if it were a variable, we do not need it to be static
}


class AtomThread implements Runnable{
	String name;
	
	AtomThread(String name){
		this.name = name;
	}
	
	public void run()	{
		System.out.println("Starting" + name);
		
		for(int i = 1; i<=3; i++) {
			System.out.println(name + " got: " + Shared4.ai.getAndSet(i));
		}
	}
}



public class AtomicDemo {

	public static void main(String[] args) {
		new Thread(new AtomThread("A")).start();
		new Thread(new AtomThread("B")).start();
		new Thread(new AtomThread("C")).start();
	 

	}

}
