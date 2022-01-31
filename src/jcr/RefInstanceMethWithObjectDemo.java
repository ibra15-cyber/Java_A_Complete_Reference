package jcr;

interface MyFunc<T>{
	//we will pass our return type at creation
	
	//method can take diff number of parameters as compared to the interface or class
	boolean func(T v1, T v2);
}

class HighTemp{
	private int hTemp;
	
	//HighTemp is a cons that will take an int
	HighTemp(int hTemp){
		this.hTemp = hTemp;
	}
	
	//an instance method
	//we will be invoking this method on an obj of HighTemp type 
	//and passing another obj of the same type as parameter
	//so if hTemp of obj is equal to the hTemp of the parameter return true
	boolean sameTemp(HighTemp obj) {
		//return true if this statement holds
		return hTemp == obj.hTemp;
	}
	
	boolean lessThanTemp(HighTemp obj) {
		//return true if this statement holds
		return hTemp < obj.hTemp; 
	}
}

public class RefInstanceMethWithObjectDemo {
	
	//static method is generic with return type int 
	//which means a return type will be passed at method calling time
	//counter method takes an array of the type generic 
	//an obj of interface MyFunc<T> which will be f
	//and an obj of return generic type
	//static generic method returns int but our interface returns boolean
	//therefore our static generic method isnt implementing the interface
	
					//workings
	//we iterate the array of the return type we choose
	//if the interface obj.invokes the implemented method 
	//increment count 
	
	static <T> int counter(T[] vals, MyFunc<T> f, T ob) {
		int count = 0;
		
		for (int i=0; i<vals.length; i++)
			if(f.func(vals[i] , ob))
				//is it about if f.func having return types
				//or is it about ob in array?
				count++;
		
		return count;
	}
	public static void main(String[] args) {
		
		int count; //this will help you to call count without name conflict
		
	
		
//......................................MINE....................................................
		//counter static method which returns int
		//takes an array weekDayHighs, then infers the lambda using obj::methodRef
		//similar to lambda call which will have been 
		HighTemp ht = new HighTemp(1);
		HighTemp ht2 = new HighTemp(2);
		MyFunc<HighTemp> interOb= (a, b) -> ht.sameTemp(ht2);
		System.out.println("my attempt " + interOb.func(ht, ht2)); //returns false
		
		//just like below but here its reference
		//f is an obj of MyFunc interface and return type specifically HighTemp
		//since its an obj of the return type, it can impl the interface method just like lambda above
		//f can be used as a ref to a method in HighTemp
		//f then invokes its 
		//or simply, f reference sameTemp method of the HighTemp class 
		//then invokes the func interface with 2 HighTemp
		//to refer to a super class version of a method === super::name
		MyFunc<HighTemp> f = HighTemp::sameTemp;
		if(f.func(ht, ht2))
			System.out.println("it worked");
		else {
			System.out.println("both aint the same");
		}
		//put them in an array
				HighTemp[] htlist = {
						ht, ht2
				};
			
				//asking the same question but using the list
		count = counter(htlist, HighTemp::sameTemp, ht); //instead of creating an obj and invoking that will method
				// <T> int counter(T[] vals, MyFunc<T> f, T ob)
				//				if(f.func(vals[i] , ob)) 
		
		//thus referencing class::methref referencing it without calling it
				//so we iterate list if there exist our passed obj ob in the list
				//the lambda expression returns true because sameTemp 
				//found the passed obj in the arguement in the list
				//hence add count
		System.out.println(count + " high temp days to same as 1........MINE");
		
//..........................................BOOK'S...................................................................
		HighTemp[]	 weekDayHighs = {
				new HighTemp(89), new HighTemp(82), 
				new HighTemp(90), new HighTemp(89), 
				new HighTemp(89), new HighTemp(91), 
				new HighTemp(84), new HighTemp(83)
		};
		//but our static method is doing something different
		//it invokes the ref method call on HighTemp
		//then passes one particular object as defined
		//if our passed obj is of the interface method (T v, T v2); where problem lies
		//we assign int count to counter because counter is a method has a return type int
		count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(9));
		// <T> int counter(T[] vals, MyFunc<T> f, T ob)
		//				if(f.func(vals[i] , ob)) 
		//so we iterate list if there exist our passed obj ob in the list
		//the lambda expression returns true because sameTemp found the passed obj in the list
		//hence add count
		System.out.println(count + " days had a high temp of 89");
		
		HighTemp[]	 weekDayHighs2 = {
				new HighTemp(32), new HighTemp(12), 
				new HighTemp(24), new HighTemp(19), 
				new HighTemp(18), new HighTemp(12), 
				new HighTemp(-1), new HighTemp(13)
		};
		
		count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(12));
		System.out.println(count + " days had a high temp less than 12");
		
		count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(89));
		System.out.println(count + " days had a high temp less than 89");
		
		count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(19));
		System.out.println(count + " days had a high temp less than 19");
		
		//sumary
		//1. counter is separate from our lambda interface and the other class
		//2. because our interface has a return type generic we can pass our class HighTemp
		//3. creating 2 obj of HighTemp, we could test our instance methods to see if they execute to true or false
		//4. our methods returns a boolean, we can use it to implement our interface method
		
	}

}
