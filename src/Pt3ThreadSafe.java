
public class Pt3ThreadSafe extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 200000000; i++) {
			Pt3Data.f();
		}
	}
	
	public static void main(String[] args) {
		Pt3ThreadSafe thread1 = new Pt3ThreadSafe();
		Pt3ThreadSafe thread2 = new Pt3ThreadSafe();
		// Run part 3
		long startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		}
		catch (InterruptedException e) {}
		long endTime = System.nanoTime();
		
		Pt3Data.printValues();
		System.out.println("Computation took " + ((endTime - startTime) / 1000000) + " milliseconds");

	}

}

class Pt3Data {
	private static int x,y,z;
	
	public static synchronized void f() {
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