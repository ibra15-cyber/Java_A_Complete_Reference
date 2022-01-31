package jcr.chp28.java.concurrency;

import java.util.concurrent.*;

class Shared{
	static int count = 0;
}

//ANOTHER CLASS 
class IncThread implements Runnable{
	String name;
	Semaphore sem;
	
	IncThread(Semaphore sem, String name)	{
		this.name = name;
		this.sem = sem;
	}
	
	public void run() {
		System.out.println("Starting "  + name);
		
		try {
			System.out.println(name + " is waiting for a permit.");
//			sem.acquire();
			System.out.println(name + " gets a permit");
			
			for(int i=0; i<5; i++) {
				Shared.count++;
				System.out.println(name + " : "+ Shared.count);	
				Thread.sleep(10); 
			}
		}catch(InterruptedException exc) {
				System.out.println(exc);
		}
		
		System.out.println(name + " releases the permit.");
//		sem.release();
		} 
}

//.................................ANOTHER CLASS
class DecThread implements Runnable{
	String name;
	Semaphore sem;
	
	DecThread(Semaphore sem, String name){
		this.sem = sem;
		this.name = name;
	}
	
	public void run()	{
		
		System.out.println("Starting " + name);
		try {
			System.out.println(name +" is waiting for a permit");
			sem.acquire();
			System.out.println(name + " gets a permit");
			
			for (int i = 0; i<5; i++) {
				Shared.count--; //decrement count from 0
				System.out.println(name +  ": " + Shared.count);
				
				Thread.sleep(10);
			}
		}catch(InterruptedException exc) {
			System.out.println(exc);
		}
		
		System.out.println(name + " release the permit.");
		sem.release();
	}
}


public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		//A is increasing but B is decreasing
		//shortcut of above
		Thread inc = new Thread(new IncThread(sem, "A"));
				inc.start();
//		new Thread(new IncThread(sem, "A")).start();
		new Thread(new DecThread(sem, "B")).start();
	}

}

