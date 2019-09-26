package com.runnablepatterns.proxyremotepattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class that contains the logic for Approved state.
 */
public class Approved extends MyState {

	public Approved(InvoicePreview _invoice) {
		super(_invoice);
		this.setDescription("Invoice Preview was approved by your manager.\nInvoice Preview ready to print.");
	}
	
	@Override
	public void validate() {
		// specific step logic
		System.out.println(this.getDescription());
		
		// if flag is set to approved
		if(getInvoice().isApprove()) {
			getInvoice().setCurrentState(getInvoice().getClosed());
		}
		else {
			getInvoice().setCurrentState(getInvoice().getRejected());
		}
	}

}