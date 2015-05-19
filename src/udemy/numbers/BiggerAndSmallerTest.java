package udemy.numbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BiggerAndSmallerTest {

	
	private BiggerAndSmaller algorithm;

	@Before
	public void setUp() {
		algorithm = new BiggerAndSmaller();
	}
	
	private int[] nums(int... ns) {
		return ns;
	}
	
	@Test
	public void numbersInIncreasingOrder() {
		
		algorithm.find(nums(2, 3, 4));
		
		assertNumbers(4, 2);
	}
	
	private void assertNumbers(int bigger, int smaller) {
		Assert.assertEquals(bigger, algorithm.getBigger());
		Assert.assertEquals(smaller, algorithm.getSmaller());
	}

	@Test
	public void numbersInDecreasingOrder() {
		
		algorithm.find(nums(4, 3, 2));
		
		assertNumbers(4, 2);
	}

	@Test
	public void numbersInAnyOrder() {
		
		algorithm.find(nums(19, 5, 2, 17, 15, 10));
		
		assertNumbers(19, 2);
	}

	@Test
	public void onlyOneNumber() {
		
		algorithm.find(nums(16));
		
		assertNumbers(16, 16);
	}

	@Test
	public void repeatedNumbers() {
		
		algorithm.find(nums(16, 2, 16, 3, 4, 5, 15, 16));
		
		assertNumbers(16, 2);
	}
}
