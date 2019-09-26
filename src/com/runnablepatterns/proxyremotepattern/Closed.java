package com.runnablepatterns.proxyremotepattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class that contains the logic for Closed state.
 */
public class Closed extends MyState {

	public Closed(InvoicePreview _invoice) {
		super(_invoice);
		this.setDescription("Invoice Preview printed.\nInvoice Preview is now a valid invoice.");
	}
	
	@Override
	public void validate() {
		// specific step logic
		System.out.println(this.getDescription());
	}

}