
public class OneThread {
	private static int x,y,z;
	
	public static void f() {
		x = x+1;
		y = y+1;
		z = z + x - y;
	}
	
	public static void printValues() {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	    System.out.println("z = " + z);
	}
	

}
