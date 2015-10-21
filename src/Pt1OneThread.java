
public class Pt1OneThread extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 200000000; i++) {
			Pt1Data.f();
		}
	}
	
	public static void main(String[] args) {
		Pt1OneThread thread1 = new Pt1OneThread();
		// Run part 1
		long startTime = System.nanoTime();
		thread1.start();
		try {
			thread1.join();
		}
		catch (InterruptedException e) {}
		long endTime = System.nanoTime();
		
		Pt1Data.printValues();
		System.out.println("Computation took " + ((endTime - startTime) / 1000000) + " milliseconds");

	}
	
}

class Pt1Data {
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
