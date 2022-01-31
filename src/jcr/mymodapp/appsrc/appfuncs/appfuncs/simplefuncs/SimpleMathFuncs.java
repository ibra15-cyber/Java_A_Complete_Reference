package jcr.mymodapp.appsrc.appfuncs.appfuncs.simplefuncs;

public class SimpleMathFuncs {
	
	//first static function
	public static boolean isFactor(int a, int b) {
		if((b%a)==0)    //if divisible by 2
			return true;
		
		return false;
	}
	
	//second static function
	public static int lcf(int a, int b) {
		
		//invoking a math method passing a para and assigning it to int a and b
		a = Math.abs(a);
		b = Math.abs(b);
		
		//if absolute value of a < less than that of  b return a, else return b as the min value
		int min = a<b ? a:b; 
		
		//we iterate from 2 and making sure 2 <= min value/2
		//thus any value that is a factor 
		for (int i = 2; i<=min/2; i++) {
			if(isFactor(i, a) && isFactor(i, b))
				return i;
		}
		return 1;
	}
	
	//third static function
	public static int gcf(int a, int b) {
		
		a = Math.abs(a);
		b = Math.abs(b);
		
		int min = a<b ? a:b; //if a < b return a, else return b;
		
		for (int i =min/2;  i>=2; i--) {
			if(isFactor(i, a) && isFactor(i, b))
				return i;
		}
		return 1;
	}
	
}
