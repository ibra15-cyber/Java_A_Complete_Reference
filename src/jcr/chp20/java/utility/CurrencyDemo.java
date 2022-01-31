package jcr.chp20.java.utility;

import java.util.Currency;
import java.util.Locale;

public class CurrencyDemo {

	public static void main(String[] args) {
	
		//no constructors 
		Currency c = Currency.getInstance(Locale.FRANCE);
		Currency d = Currency.getInstance(Locale.UK);
		Currency e = Currency.getInstance(Locale.US);
		
		System.out.println("Symbol: " + c.getSymbol());
		System.out.println(d.getSymbol());
		System.out.println(e.getSymbol());
		
		System.out.println("Get default fractional digits: "+ c.getDefaultFractionDigits());

	}

}
