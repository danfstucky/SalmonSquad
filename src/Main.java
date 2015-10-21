
public class Main {
	public static void main(String[] args) {
		// Run part 1
		long startTime = System.nanoTime();
		for (int i = 0; i < 200000000; i++) {
			OneThread.f();
		}
		long endTime = System.nanoTime();
		OneThread.printValues();
		System.out.println("Computation took " + ((endTime - startTime) / 1000000) + " milliseconds");

	}
}
