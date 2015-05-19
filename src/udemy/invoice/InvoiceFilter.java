package udemy.invoice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InvoiceFilter {

	private InvoiceRepository invoices;
	public InvoiceFilter(InvoiceRepository invoices) {
		this.invoices = invoices;
	}
	
	public List<Invoice> filter() {
		
		List<Invoice> filtered = new ArrayList<Invoice>();
		
		for(Invoice invoice : invoices.all()) {
			if (invoice.getAmount() > 2000) filtered.add(invoice);
			else if (invoice.getAmount() < 2000 && invoice.getCustomer().equals("MICROSOFT")) filtered.add(invoice);
			else if (invoice.getDate().get(Calendar.YEAR) < 1999) filtered.add(invoice);
		}
		
		return filtered;
	}
}