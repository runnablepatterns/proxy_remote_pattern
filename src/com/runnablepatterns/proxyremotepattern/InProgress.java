package com.runnablepatterns.proxyremotepattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class that contains the logic for InProgress state.
 */
public class InProgress extends MyState {

	public InProgress(InvoicePreview _invoice) {
		super(_invoice);
		this.setDescription("Invoice Preview created.\nYou can do any changes.");
	}
	
	@Override
	public void validate() {
		// specific step logic
		System.out.println(this.getDescription());
		
		// change the state to pending
		getInvoice().setCurrentState(getInvoice().getPending());
	}

}
