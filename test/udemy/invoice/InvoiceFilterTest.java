package udemy.invoice;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class InvoiceFilterTest {

	private InvoiceFilter filter;
	private InvoiceRepository repo;
	@Before
	public void setUp() {
		repo = Mockito.mock(InvoiceRepository.class);
		filter = new InvoiceFilter(repo);
	}
	
	@Test
	public void filterInvoicesHigherThan2000() {
		Invoice inv1 = new Invoice(Calendar.getInstance(), "MAURICIO", 5000);
		Invoice inv2 = new Invoice(Calendar.getInstance(), "MAURICIO", 200);
		
		Mockito.when(repo.all()).thenReturn(Arrays.asList(inv1, inv2));
		
		List<Invoice> result = filter.filter();
		
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(inv1, result.get(0));
		
	}

	@Test
	public void filterMicrosoftInvoices() {
		Invoice inv1 = new Invoice(Calendar.getInstance(), "MICROSOFT", 1000);
		
		Mockito.when(repo.all()).thenReturn(Arrays.asList(inv1));
		
		List<Invoice> result = filter.filter();
		
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(inv1, result.get(0));
		
	}
}
