package jcr.chp28.java.concurrency;

import java.util.concurrent.Phaser;

//a thread class taking a phaser obj and a string
//it registers the phaser obj
//prints the name of the string starting
//it pauses
//wait for 100 milliseconds
//restart but under phase two
//sleep again 
//and over and over again
class MyThread5 implements Runnable {
	Phaser phaser;
	String name;
	
	MyThread5(Phaser phaser, String name){
		this.phaser = phaser;
		this.name = name;
		phaser.register()	; //invoking register on our phaser object
	}
	
	public void run() {
		System.out.println("Thread " + name + " Begining Phase One");
		phaser.arriveAndAwaitAdvance() ;
		
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {
			System.out.println(e);
		}
		
		System.out.println("Thread " + name + " Begining Phase two");
		phaser.arriveAndAwaitAdvance();
		
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {
			System.out.println(e);
		}
		
		System.out.println("Thread " + name + " Begining Phase Three");
		Phaser phaser2 = new Phaser();
		phaser2.arriveAndDeregister();
	}
	
}

public class PharserDemo {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);
		int curPhase;
		
		System.out.println("Starting");
		
		new Thread(new MyThread5(phaser, "A")).start();	//our thread takes our new thread with a phaser obj and a string
		new Thread(new MyThread5(phaser, "B")).start();
		new Thread(new MyThread5(phaser, "C")).start();
		
		curPhase = phaser.getPhase(); //get current phase
		phaser.arriveAndAwaitAdvance(); //then wait or suspend until say phase 0 is complete in that order
		System.out.println("Phase " + curPhase + " Complete"); //after waiting 
		
		curPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + curPhase + " Complete");
		
		phaser.arriveAndDeregister(); //this was anticipated in the above string
		
		//at the end of the third time phaser is terminated so we print that
		if(phaser.isTerminated())
			System.out.println("The Phaser is terminated");
	}

}
