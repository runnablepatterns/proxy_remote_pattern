package com.runnablepatterns.proxyremotepattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class that contains the logic for Pending state.
 */
public class Pending extends MyState {

	public Pending(InvoicePreview _invoice) {
		super(_invoice);
		this.setDescription("Invoice Preview sent for approval.\nWaiting for manager approval.");
	}
	
	@Override
	public void validate() {
		// specific step logic
		System.out.println(this.getDescription());
		
		// if flagg is set to approve
		if(getInvoice().isApprove()) {
			// move to approved
			getInvoice().setCurrentState(getInvoice().getApproved());
		}
		else {
			// move to rejected
			getInvoice().setCurrentState(getInvoice().getRejected());
		}
	}

}
