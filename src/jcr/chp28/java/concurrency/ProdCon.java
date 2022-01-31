package jcr.chp28.java.concurrency;

/**
 * q defines put and get mutator methods to change the states of our program
 * both will first seek to acquire semaphore before it work
 * then class producer implements the the put method of the q class
 * and class consumer implements the get method of the q class
 * 
 * then we created a thread object for both class producer and consumer 
 * because they implemented the runnable interface
 * 
 * hence semaphore synchronized the get and put
 * if the acquire is commented out, different thing happens
 * 
 */
import java.util.concurrent.Semaphore;

class Q  {
	int n;
	static Semaphore semCon = new Semaphore(0);
	static Semaphore semprod = new Semaphore(1);
	
	void get() {
		try {
			semCon.acquire();				//require key on con semaphore
		} catch(InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		
		System.out.println("Got: " + n);
		semprod.release();
	}
	
	void put(int n) {
		try {
			semprod.acquire();
		} catch(InterruptedException e) {
			System.out.println("InterrruptedException caught");
		}
		
		this.n = n;
		System.out.println("Put: " + n);
		semCon.release();
	}
}

class Producer implements Runnable{
	Q q;
	Producer(Q q){
		this.q = q;
	}
	
	public void run() {
		for(int i = 0; i<20; i++)
			q.put(i);
	}
}

class Consumer implements Runnable{
	Q q;
	Consumer(Q q){
		this.q = q;
	}
	
	public void run() {
		for(int i = 0; i<20; i++)
			q.get();
	}
}


public class ProdCon{
	public static void main(String[] args) {
		Q q = new Q();
		Thread thread1 = new Thread(new Consumer(q), "Consumer");
		thread1.start();
		
		//shortcut form for Producer
		new Thread(new Producer(q), "Producer").start();
		

	}

}
