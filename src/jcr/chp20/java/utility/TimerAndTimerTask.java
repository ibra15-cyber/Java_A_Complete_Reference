package jcr.chp20.java.utility;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

class MyTimerTask extends TimerTask{
	
	public void run() {
		System.out.println("Timer task executed");
	}
}

public class TimerAndTimerTask {

	public static void main(String[] args) {
		
//		Timer( )
//		Timer(boolean DThread)
//		Timer(String tName)
//		Timer(String tName, boolean DThread)
		
		//my class mytimerobj
		MyTimerTask myTask = new MyTimerTask();	
		Timer myTimer = new Timer();
		
		//set an initial delay of 1 second
		//then repeat every half second
		myTimer.schedule(myTask, 1000, 500);
		
		try {
			Thread.sleep(50000);	//5 seconds
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		myTimer.cancel();
		
		//................................timer task and timer mine
		
		
		
		
		
		
		
		

	}

}
