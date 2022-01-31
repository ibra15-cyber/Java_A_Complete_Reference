package jcr.chp17.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Box{
	double width;
	double height;
	double depth;
	
	Box(double width, double height, double depth){
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	//overridign the toString class
	public String toString() {
		return "Dimensioons are " + width + " by " + depth + " by " + height + ".";
	}
}

public class First {

	public static void main(String[] args) throws IOException {
		char chars[]	= {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		
		String s = new String(chars);
		System.out.println(s);
		
		
		//same 
		String s2 = new String("abc");
		System.out.println(s2);
		
		//String literal
		String s3 = "abc";
		System.out.println(s3);
		
		//sub range
		String s4 = new String(chars, 2, 3);
		System.out.println(s4);
		
		//...........................................string from another........................
		char[]	c = {'J', 'a', 'v', 'a'};
		String s5 = new String(c);
		System.out.println(s5);
		
		String s6 = new String(s5);
		System.out.println(s6);
		
		//.................................string from subset of char array......................
		//so you can get the string representation of both char and byte array as string
		
		byte[] ascii	= {65, 66, 67, 68, 69, 70};
		System.out.println(ascii);
		
		String s7 = new String(ascii);
		System.out.println(s7);
				
		String s8 = new String(ascii, 2, 3);
		System.out.println(s8);
		
		//...............................................string from stringBuffer...........................
		
		StringBuffer sb = new StringBuffer("constructing string using stringBuffer");
		System.out.println(sb);
		System.out.println(sb.charAt(0));
		
		//...............................................string methods.............................................
		
		System.out.println("length of the stringBuilder string: " + sb.length());
		
		//..............................................String literals...................................................
		
		String sl = "this is a string literal";
		System.out.println(sl);
		System.out.println(sl.length()); 
		
		
		//................................................string concatenation.................................
		String age = "9";
		String sc = "He is " + age + " yeaers old";
		System.out.println(sc);
		
		
		//.............................................long string....................................................
		String longStr = "this could have been " + 
						" a very long line that would have " + 
						" wrapped around. But string ocncatenation " + 
						"prvents this.";
		System.out.println(longStr);
		
		//concatenation with other data types
		int age2 = 9;
		String sc2 = "He is " + age2 + " years old";
		System.out.println(sc2);
		
		//becareful
		String sc3 = "four: " + 2 + 2;
		System.out.println(sc3);
		
		String sc4 = "four: " + (2 + 2);
		System.out.println(sc4);
		
		
		//..................................................string conversion and toString().................
		
		Box b = new Box(10, 12, 14);
		
		System.out.println(b.toString()); //same as below
		String sbox = "Box b: " + b;
		
		System.out.println(sbox);
		
		//..................................................Char extraction................................................
		
		char ch;
		ch = "abc".charAt(1);
		System.out.println(ch);
		
		//or it will be returning a char so the return type should be char 
		char cs = "a string".charAt(3);
		
		//..................................................getChars.............................................................
		
		String getchars = "this is a demo of the getChars method.";
		int start = 10;
		int end = 14;
		char buff[]	= new char[end - start]; //size of our char array is 14-10
		
		//char array example mine
		char[] carr = new char[5];
		carr[0] = 'a';
		carr[1] = 'b';
		carr[2] = 'c';
		carr[3] = 'd';
		
		System.out.println(carr);
		
		getchars.getChars(start, end, buff, 0);
		//we are trying to get chars in string but using getChars method
		//getChars take a start, an end, an array to store the char and an end
		System.out.println(buff);
		
		//using byte array instead of char array as above
		byte[] barr = new byte[end - start];
		//getchars.getChars(start, end, barr, 0); not working
		
		
		//..................................................toCharArray......................................
		System.out.println("abcdef".toCharArray());
		
		char[ ] tochararray = "abcdefghijklmnopqurstuvwxyz".toCharArray();
		System.out.println(tochararray);
		
	
		//..................................................equals and equalsIgnoreCase()............
		
		String eqto = "Hello";
		String eqto2 = "Hello";
		String eqto3 = "Good-bye";
		String eqto4 = "HELLO";
		
		System.out.println(eqto + " equals " + eqto2 + " --> " + eqto.equals(eqto2));
		System.out.println(eqto + " equals " + eqto3 + " --> " + eqto.equals(eqto3));
		System.out.println(eqto + " equals " + eqto4 + " --> " + eqto.equals(eqto4));
		System.out.println(eqto + " equalsIgnoreCase " + eqto2 + " --> " + eqto.equalsIgnoreCase(eqto2));
		
		
		//........................................................regionMatches()....................................
		
//		String strregion = "test of region q";
//		String strregion2 = "again test of region ";
//		boolean bol = strregion.regionMatches(0, strregion2, , 0);
//		System.out.println(bol);
		
		//.........................................................endsWith and startWith......................
		
		System.out.println("Foobar".startsWith("Foo"));
		System.out.println("Foobar".startsWith("bar", 3));
		
		System.out.println("Foobar".endsWith("bar")); //true
		
		
		//.......................................................equals() vs ==.........................................
		
		String sq1 = "Hello";
		String sq2 = new String(sq1);
		
		System.out.println(sq1 + " equals " + sq2 + " -> " + sq1.equals(sq2));
		System.out.println(sq1 + " == " + sq2 + " -> " + (sq1 == sq2)); 
		
		//.......................................................compareTo().............................................
		
		System.out.println("abc".compareTo("abc"));
		System.out.println("abc".compareTo("cde"));
		System.out.println("c".compareTo("b"));
		//returns 1, 0 or -1 for > = <
		System.out.println("abc".compareToIgnoreCase("ABC"));
		
		//....................................................searching string........................................
		
		System.out.println("abcde".indexOf("c"));//returns first occurance of c
		System.out.println("abcdefcefc".lastIndexOf('c')); //"c" this too will work
		System.out.println("abcdefcefc".lastIndexOf("abc")); //abc
		
		
		String strindexof = "Now is the time for all good men" + 
										" to come to the aid of their country.";
		
		System.out.println(strindexof);
		
		System.out.println("index of (t) = " + strindexof.indexOf("t"));
		System.out.println("lastindexof (t) = " + strindexof.lastIndexOf("t"));
		System.out.println("index of (the) = " + strindexof.indexOf("the"));
		System.out.println("lastindexof (the) = " + strindexof.lastIndexOf("the"));
		System.out.println("index of (t, 10) = " + strindexof.indexOf("t", 10)); //t afer index 10
		System.out.println("index of (t) = " + strindexof.indexOf("t"));
		System.out.println("LastIndexof (t, 60) = " + strindexof.indexOf("t", 60));
		
		//string replacement
		String org = "This is a test. This is, too.";
		String search = "is";
		String sub = "was";
		String result = "";
		int i;
		
		do {
			System.out.println(org);
			 i = org.indexOf(search);
			// System.out.println(i);
			if(i != -1) {
				result = org.substring(0, i); 
//				System.out.println(result);
				//add was to th == thwas
				result = result + sub;
				//thwas + (i=2) + (search.length =2)
				result = result + org.substring(i + search.length());
				org = result;
			}
		}while(i != -1);
		
		//...............................................concatenation.......................................................
		
		String conc = "one";
		String conc2 = "two";
		System.out.println(conc + conc2);
		System.out.println(conc2.concat(" three"));
		
		//...............................................replace.................................................................
		
		String rep = "hello".replace('l', '4');
		System.out.println(rep);
		
		
		//.............................................trim()...............................................................
		
		System.out.println("  remove the spaces front and back ".trim());
		
		//BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
//		String strtrim;
//		System.out.println("Enter 'stop' to quit.");
//		System.out.println("Enter State: ");
//		do {
//			strtrim = br.readLine();
//			strtrim = strtrim.trim();  //handles both leading and trailing string
//			
//			if(strtrim.equals("Illinois")) 
//				System.out.println("Capital is Springfield");
//			else if (strtrim.equals("Missouri"))
//			System.out.println("Capital is Jefferson City");
//			else if(strtrim.equals("California"))
//			System.out.println("Capital is Sacremento.");
//			else if(strtrim.equals("Washington"))
//			System.out.println("Capital is Olympia");
//		}while(!strtrim.equals("Stop"));
		
		//........................................strip().........................................................................
		
		//strip and trim removes leading and trailing spaces
		System.out.println("strip(): " + "strip this for me".strip());
		
		String strstrp = "         my name yeah!              " ;
		
		System.out.println("strip in real time " +strstrp.strip());
		
		
		//...................................................changing case..................................................
		
		String tolower = "This is a test.";
		System.out.println(tolower);
		
		System.out.println(tolower.toUpperCase());
		System.out.println(tolower.toLowerCase());
		
		
		//..........................................................joining strings.............................................
		
		String resultjoin = String.join(" ", "Alpha", "Beta", "Gamma");
		
		//separate this with spaces
		System.out.println(resultjoin);
		
		//join this with comma
		String resultjoin2 = String.join(", ", "John", "ID#: 569", "E-mail: John@herbSchildt.com");
		System.out.println(resultjoin2);
		//..........................................................data converstion using valueOf................................
		int strvalueof = 5;
		System.out.println("conversion " + String.valueOf(strvalueof));
		double db = 32.3;
		System.out.println("conversion " + String.valueOf( db));
		char[] chh = { 'a', 'b', 'c'};
		System.out.println("conversion " + String.valueOf( chh));

		
		//......................................................StringBuffer...................................................
		
		StringBuffer sbagain = new StringBuffer("Hello");
		
		System.out.println("buffer = " + sbagain);
		System.out.println("length = " + sbagain.length()); //5
		System.out.println("capacity = " + sbagain.capacity());
		
		sbagain.setLength(30);
		System.out.println("length = " + sbagain.length()); //set to 30;
		
		//.........................................................stringbuffer charat and setcharat
		
		StringBuffer sbc = new StringBuffer("Hello");
		System.out.println("original: "+ sbc);
		System.out.println("charAt(2) before = " + sbc.charAt(4));
		
		//Changing the index 2 to m
		sbc.setCharAt(2, 'm');
		System.out.println("length = " + sbc);
		
//		sbc.setLength(2); //trancates or expand my string
//		System.out.println("original: "+ sbc);
		
		
		//..........................................................getChars()........................................
		char[]  chhh = new char[2];
		sbc.getChars(2, 4, chhh, 0);
		System.out.println(chhh); //2 = ml
		
		//.............................................................append......................
		
		sbc.append(2); //append 2
		System.out.println("current: "+ sbc);
		
		sbc.append(" appended");
		System.out.println("currentl: "+ sbc);
		
	
		int a = 42;
		StringBuffer sbap = new StringBuffer(40);
		
			String strap = sbap.append("a = ").append(a).append("!").toString();
//			System.out.println(strap);
			
			
		StringBuffer strap1 = sbap.append("a = ").append(a).append("!");
		System.out.println(strap1);
		
		//..........................................................insert............................................
		String strin = "I java!";
	//	strin.insert(); 
		StringBuffer strinb = new StringBuffer("i java!");
		StringBuffer strinbb = strinb.insert(2, "love ");
		System.out.println(strinbb);
		
		//......................................................reverse......................................
		
		strinbb.reverse();
		System.out.println("reverse:" + strinbb);
		
		//........................................................delete......................................
		StringBuffer strdel = new StringBuffer("I love java");
		strdel.delete(2, 6);
		System.out.println("del a substring: " + strdel);
		
		//delete at charAt
		strdel.deleteCharAt(3); //dele j
		System.out.println("del j: " + strdel);
		
		
		//......................................................replace............................................
		
		StringBuffer strrep = new StringBuffer("I love java");
		strrep.replace(2, 6, "like");
		System.out.println("replacing love with like: " + strrep);
		
		//.........................................................substring..........................................
		
		StringBuffer strsubs = new StringBuffer("I'm in love with java");
		
		System.out.println(strsubs.substring(7));
		
		System.out.println(strsubs.substring(7, 11));
		
		//..............................................................indexOf............................
		
		System.out.println(strsubs.indexOf("love"));
		System.out.println("abcedefe who is who".lastIndexOf("who"));
		
		
	
		
		
		
		
		
		
				
		
		
		
		
	}

}
