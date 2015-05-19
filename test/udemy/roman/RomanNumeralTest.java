package udemy.roman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RomanNumeralTest {

	private RomanNumeral roman;

	@Before
	public void setUp() {
		roman = new RomanNumeral();
	}

	@Test
	public void aSingleNumber() {
		Assert.assertEquals(1, roman.convert("I"));
		Assert.assertEquals(5, roman.convert("V"));
		Assert.assertEquals(10, roman.convert("X"));
	}

	@Test
	public void aComposedNumber() {
		Assert.assertEquals(2, roman.convert("II"));
		Assert.assertEquals(6, roman.convert("VI"));
		Assert.assertEquals(16, roman.convert("XVI"));
	}
	
	@Test
	public void aComposedNumberWithRegression() {
		Assert.assertEquals(4, roman.convert("IV"));
		Assert.assertEquals(14, roman.convert("XIV"));
		
	}
}
