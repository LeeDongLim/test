package EX001;

public class Multithread {

	public static void main(String[] args) {
		Thread thread = new Thread(new DigitRunnableImpl());
		thread.run();	
		
		thread.start();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
	}
}
