package com.runnablepatterns.proxyremotepattern;

import java.rmi.RemoteException;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used by the supervisor to monitor InvoicePreviews on terminals
 */
public class InvoicePreviewMonitor {

	/**
	 * Variable to store the Proxy object
	 */
	InvoicePreviewRemote invoicePreview;
	
	/**
	 * Overloaded constructor used to initialize the InvoicePreview
	 * @param _invoicePreview The invoice to review
	 */
	public InvoicePreviewMonitor(InvoicePreviewRemote _invoicePreview) {
		this.invoicePreview = _invoicePreview;
	}
	
	/**
	 * Method that prints the required information
	 */
	public void getTerminalReport() {
		try {
			System.out.println(String.format("TerminalID: %s", invoicePreview.getTerminal()));
			System.out.println(String.format("InvoicePreview State: %s", invoicePreview.getCurrentState()));
			System.out.println(String.format("Agent Name: %s", invoicePreview.getAgentName()));
			System.out.println();
		}
		catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
}
