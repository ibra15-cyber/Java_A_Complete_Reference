package jcr.chp28.java.concurrency;

import java.util.concurrent.locks.ReentrantLock;

class Shared3{
	static int count = 0;
}


class LockThread implements Runnable {
	String name;
	ReentrantLock lock;
	
	LockThread(ReentrantLock lock, String name){
		this.lock = lock;
		this.name = name;
	}
	
	public void run()	{
		//starting a particular string passed
		System.out.println("Starting " + name);
		
		try {
			//string name is waiting to lock count
			System.out.println(name + " is waiting to lock count.");
			lock.lock(); //this will do the actual work
			System.out.println(name + " is locking count."); //stirng is unlocking countf. ancipated from above
			
			
			Shared3.count++; //increment string name to 1
			System.out.println(name + " : " + Shared3.count); //string name with the count num
			
			System.out.println(name + " is sleeping."); //anticipating calling sleep
			Thread.sleep(1000);
		} catch(InterruptedException exc) {
			System.out.println(exc);
		}finally {
			System.out.println(name + " is unlocking count."); //anticipating unlock
			lock.unlock(); //the code that does the unlock
		}
	}
	
}
public class LockDemo {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock(); //we created an obj to be passed into our lock class
		
		new Thread(new LockThread(lock, "A")).start(); //starting our thread using shortcut
		new Thread(new LockThread(lock, "B")).start();
	}

}
