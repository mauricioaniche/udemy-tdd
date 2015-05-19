package udemy.numbers;

public class BiggerAndSmaller {

	private int bigger = Integer.MIN_VALUE;
	private int smaller = Integer.MAX_VALUE;

	public void find(int[] numbers) {
		for(int n : numbers) {
			if(n > bigger) bigger = n;
			if(n < smaller) smaller = n;
		}
	}
	
	public int getBigger() {
		return bigger;
	}
	
	public int getSmaller() {
		return smaller;
	}
}
