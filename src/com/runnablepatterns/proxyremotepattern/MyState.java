package com.runnablepatterns.proxyremotepattern;

import java.io.Serializable;;
/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface used to group all available states for InvoicePreview.
 */
public abstract class MyState implements Serializable{
	
	/**
	 * Variable used to store a reference to InvoicePreview
	 */
	private transient InvoicePreview invoice;
	
	/**
	 * Stores current step description
	 */
	private String description;
	
	/**
	 * Overloaded constructor used to received a reference to InvoicePreview
	 * @param _invoice
	 */
	public MyState(InvoicePreview _invoice) {
		setInvoice(_invoice);
	}
	
	/**
	 * Method used to perform required actions in the specific step
	 */
	public abstract void validate();

	/**
	 * @return the invoice
	 */
	protected InvoicePreview getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice the invoice to set
	 */
	protected void setInvoice(InvoicePreview invoice) {
		this.invoice = invoice;
	}
	
	/**
	 * Set the current Step description
	 * @param _description
	 */
	protected void setDescription(String _description) {
		this.description = _description;
	}
	
	/**
	 * Get the current step description
	 * @return
	 */
	protected String getDescription() {
		return this.description;
	}
	
	/**
	 * Method used when printing the state object
	 */
	public String toString() {
		return this.getDescription();
	}
}