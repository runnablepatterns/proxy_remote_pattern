package com.runnablepatterns.proxyremotedemo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.runnablepatterns.proxyremotepattern.InvoicePreviewMonitor;
import com.runnablepatterns.proxyremotepattern.InvoicePreviewRemote;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to demonstrate Proxy Remote Client Pattern
 */
public class ProxyRemoteClientDemo {
	
	/**
	 * Variable to get the registry from the server
	 */
	static Registry registry = null;
	
	public static void main(String[] args) {
		try
		{
			// store all terminal URLs
			String[] terminals = {
					"rmi://localhost:9090/terminalA",
					"rmi://localhost:9090/terminalB",
					"rmi://localhost:9090/terminalC"};
			
			// get the registry
			registry = LocateRegistry.getRegistry("localhost", 9090);
			
			// create an array of monitors
			InvoicePreviewMonitor[] invoiceMonitors = new InvoicePreviewMonitor[terminals.length];
			
			// go over each terminal and create a monitor
			for(int index = 0; index < terminals.length; index++) {
				try {
					// get the Invoice from the server registry
					InvoicePreviewRemote invoicePreview = (InvoicePreviewRemote)registry.lookup(terminals[index]);
					
					// add the new monitor
					invoiceMonitors[index] = new InvoicePreviewMonitor(invoicePreview);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			// iterate over eaxh monitor
			for(int index = 0; index < invoiceMonitors.length; index++) {
				// print the report
				invoiceMonitors[index].getTerminalReport();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
