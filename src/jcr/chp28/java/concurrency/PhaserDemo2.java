package jcr.chp28.java.concurrency;

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser{
	int numPhases;
	
	MyPhaser(int parties, int phaseCount){
		super(parties);
		numPhases = phaseCount -1; //subtract from our passed  phaser count
	}
	
	protected boolean onAdvance(int p, int regParties) {
		System.out.println("Phase " + p + " Completed\n"); 
		
		if(p==numPhases || regParties == 0) 
			return true;
		 
		return false;
		
	}
}

class MyThread6 implements Runnable{
	Phaser phsr;
	String name;
	
	MyThread6(Phaser phsr, String name) {
		this.phsr = phsr;
		this.name  = name;
		phsr.register(); //register the passed phaser object
	}
	
	public void run() {
		
		while(!phsr.isTerminated()) { //while our phaser obj hasn't terminated
			System.out.println("Thread "+ name + " Begining Phase" + phsr.getPhase());
			
			phsr.arriveAndAwaitAdvance();
			
			try {
				Thread.sleep(100);			
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}


public class PhaserDemo2 {

	public static void main(String[] args) {
		MyPhaser phsr = new MyPhaser(1, 4);
		
		System.out.println("Starting\n");
		
		new Thread(new MyThread6(phsr, "A")).start();
		new Thread(new MyThread6(phsr, "B")).start();
		new Thread(new MyThread6(phsr, "C")).start();
		
		while(!phsr.isTerminated()) {
			phsr.arriveAndAwaitAdvance();
		}
		
		System.out.println("The Phaser is terminated");

	}

}
