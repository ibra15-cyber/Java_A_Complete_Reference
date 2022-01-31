package jcr.chp28.java.concurrency;

import java.util.concurrent.Exchanger;

class MakeString implements Runnable {
	Exchanger<String> ex;
	String str;
	
	MakeString(Exchanger<String> ex){
		this.ex = ex;
		str = "";
	}
	
	public void run() {
		char ch = 'A';
		
		for(int i = 0; i<3; i++) {	//three rows running 5 times each	
			for(int j=0; j<5; j++) {
				str += ch++;			//increment our char A in ascii and add to our string
			}
		
			try {
				str = ex.exchange(str);	//now our exchanger obj is invoking our method exchange on the str
			} catch(InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}


class UseString implements Runnable{
	Exchanger<String> ex;
	String str;
	
	UseString(Exchanger<String> ex){
		this.ex = ex;
	}
	
	public void run() {
		
		for(int i = 0; i<3; i++) {
		
			try {
				str = ex.exchange(new String()); //str here is running exchange method of our obj exe and passing empty stirng
				System.out.println("Got: " +str);
			} catch(InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}


public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger<String> exgr  = new Exchanger<String>(); //creating a string exchanger object
		
		new Thread(new UseString(exgr)).start();  //starting both of our thread classes
		new Thread(new MakeString(exgr)).start(); //each one of our runnable class takes our obj exchanger
		
	}

}