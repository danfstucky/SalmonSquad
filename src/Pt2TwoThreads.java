
public class Pt2TwoThreads extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 200000000; i++) {
			Pt2Data.f();
		}
	}
	
	public static void main(String[] args) {
		Pt2TwoThreads thread1 = new Pt2TwoThreads();
		Pt2TwoThreads thread2 = new Pt2TwoThreads();
		// Run part 2
		long startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		}
		catch (InterruptedException e) {}
		long endTime = System.nanoTime();
		
		Pt2Data.printValues();
		System.out.println("Computation took " + ((endTime - startTime) / 1000000) + " milliseconds");

	}

}

class Pt2Data {
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