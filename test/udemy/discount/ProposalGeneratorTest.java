package udemy.discount;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class ProposalGeneratorTest {

	@Test
	public void discountWhenChristmas() {
		
		Basket basket = new BasketBuilder().w("MACBOOK", 1000).build();
		
		Calendar christmas = new GregorianCalendar(2015, Calendar.DECEMBER, 25);
		Clock fakeClock = Mockito.mock(Clock.class);
		Mockito.when(fakeClock.now()).thenReturn(christmas);
		
		ProposalGenerator generator = new ProposalGenerator(fakeClock);
		double finalAmount = generator.calculateDiscount(basket);
		
		Assert.assertEquals(1000*0.15, finalAmount, 0.0001);
	}
}
