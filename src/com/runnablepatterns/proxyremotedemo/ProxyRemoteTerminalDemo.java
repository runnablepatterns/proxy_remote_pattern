package com.runnablepatterns.proxyremotedemo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.runnablepatterns.proxyremotepattern.InvoicePreview;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to demonstrate Proxy Remote Server Pattern
 */
public class ProxyRemoteTerminalDemo {

	/**
	 * Variable to store RMI registry reference
	 */
	static Registry registry = null;
	
	public static void main(String[] args) {
		try
		{			
			// create registry
			registry = LocateRegistry.createRegistry(9090);
			
			// create the invoices
			InvoicePreview invoiceA = new InvoicePreview("John W", "TerminalA");
			InvoicePreview invoiceB = new InvoicePreview("Tim J", "TerminalB");
			InvoicePreview invoiceC = new InvoicePreview("Carlos M", "TerminalC");
			
			System.out.println("Terminal A");
			// first we force rejection flow
			invoiceA.setApprove(false);
			
			// start moving in the flow
			invoiceA.nextAction();
			invoiceA.nextAction();
			invoiceA.nextAction();
			// restart the invoice check
			invoiceA.setApprove(true);
			invoiceA.nextAction();
			invoiceA.nextAction();
			invoiceA.nextAction();
			System.out.println(invoiceA.getCurrentState());
			System.out.println();
			
			// process terminal B invoice
			System.out.println("Terminal B");
			invoiceB.setApprove(true);
			invoiceB.nextAction();
			invoiceB.nextAction();
			System.out.println(invoiceB.getCurrentState());
			System.out.println();
			
			// process terminal C invoice
			System.out.println("Terminal C");
			invoiceC.setApprove(false);
			invoiceC.nextAction();
			invoiceC.nextAction();
			System.out.println(invoiceC.getCurrentState());
			System.out.println();
			
			// bind the URL and the object
			registry.rebind("rmi://localhost:9090/terminalA", invoiceA);
			registry.rebind("rmi://localhost:9090/terminalB", invoiceB);
			registry.rebind("rmi://localhost:9090/terminalC", invoiceC);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
