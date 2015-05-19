package udemy.discount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiscountApplierTest {

	private DiscountApplier applier;

	@Before
	public void setUp() {
		applier = new DiscountApplier();
	}
	
	@Test
	public void discountForMacAndIphoneTogether() {
		
		Basket basket = new BasketBuilder()
			.w("MACBOOK", 100)
			.w("IPHONE", 50)
			.build();
		
		applier.apply(basket);

		double expected = (100 + 50) * 0.85;
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}

	@Test
	public void discountForNotebookAndWindowsPhoneTogether() {
		
		Basket basket = new BasketBuilder()
				.w("NOTEBOOK", 100)
				.w("WINDOWS PHONE", 50)
				.build();
		
		applier.apply(basket);
		
		double expected = (100 + 50) * (1 - 0.12);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}

	@Test
	public void discountForXbox() {
		
		Basket basket = new BasketBuilder()
				.w("XBOX", 100)
				.build();
		
		applier.apply(basket);
		
		double expected = (100) * (1 - 0.7);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}

	@Test
	public void discountForLessThanTwoItemsLesserThanAThousand() {
		
		Basket basket = new BasketBuilder()
				.w("REFRIGERATOR", 100)
				.build();
		
		applier.apply(basket);
		
		double expected = (100) * (1 - 0.02);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}

	@Test
	public void discountFor3or4Products() {
		
		Basket basket = new BasketBuilder()
				.w("REFRIGERATOR", 2000)
				.w("DISH WASHER", 500)
				.w("TRASH CAN", 2500)
				.build();
		
		applier.apply(basket);
		
		double expected = (2000 + 500 + 2500) * (1 - 0.05);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}

	@Test
	public void discountForMoreThan5Products() {
		
		Basket basket = new BasketBuilder()
				.w("REFRIGERATOR", 2000)
				.w("DISH WASHER", 500)
				.w("TRASH CAN", 2500)
				.w("BED", 400)
				.w("TOILET", 200)
				.build();
		
		applier.apply(basket);
		
		double expected = (2000 + 500 + 2500 + 400 + 200) * (1 - 0.06);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
}
