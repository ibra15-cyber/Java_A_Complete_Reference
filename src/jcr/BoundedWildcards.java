package jcr;

//In general, to establish an upper bound for a wildcard, use the following type
//of wildcard expression:   <? extends superclass> for upper bound
//for lower bound : <? extends subclass>


class TwoD{
	int x, y;
	
	TwoD(int a, int b){
		x = a;
		y = b;
	}	
}
	
class ThreeD extends TwoD{
	int z;
	
	ThreeD(int a, int b, int c){
		super(a, b);
		z = c;
	}
}
	
class FourD extends ThreeD{
	int t;
		
	FourD(int a, int b, int c, int d){
		super(a, b, c);
		t = d;	
	}
}

class Coords<T extends TwoD>{ 
	//class Coords allows unknow T obj/classes to exten TwoD
	T[] coords;
	
	Coords(T[] o){
		coords = o;
	}
}

//Demonstrate a bounded wildcard


public class BoundedWildcards {
	
	static void showXY(Coords<?> c) {
		System.out.println ("X Y Coordinates");
		for (int i = 0; i < c.coords.length; i ++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y);	
			System.out.println();
		}
	}
		
	static void showXYZ(Coords<? extends ThreeD> c) {
		System.out.println ("X Y Z Coordinates");
		for (int i = 0; i < c.coords.length; i ++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y + 
					" " + c.coords[i].z);
			System.out.println();
		}
	}
	
	static void showAll(Coords<? extends FourD> c) {
		System.out.println ("X Y Z T Coordinates");
		for (int i = 0; i < c.coords.length; i ++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y + 
					" " + c.coords[i].z + " " + c.coords[i].t);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//arrays of a of objects of class TwoD which takes 2 parameters/ coordinates 2D
		TwoD[] td = {
				new TwoD(0, 0), 
				new TwoD(7, 9),
				new TwoD(18, 4),
				new TwoD(-1, -23)
		};
		
		//passing array of coordinates (which is modeled by class TwoD) into generic class Coords<>
		Coords<TwoD>	 tdlocs = new Coords<TwoD>(td);
		
		System.out.println("Contents of tdlocs");
		showXY(tdlocs);
//		showXYZ(tdlocs);
//		showAll(tdlocs);
		
		//now create some FourD objects.
		FourD[] fd = {
				new FourD(1, 2, 3, 4), 
				new FourD(6, 8, 14, 8),
				new FourD(22, 9, 4, 9),
				new FourD(3, -2, -23, 17)
		};
		
		Coords<FourD>	fdlocs = new Coords<FourD>(fd);
		
		System.out.println("Contents of fdlocs");
		showXY(fdlocs);
		showXYZ(fdlocs);
		showAll(fdlocs);
		
		
	}

}
