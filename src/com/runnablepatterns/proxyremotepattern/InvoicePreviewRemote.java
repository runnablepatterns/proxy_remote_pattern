package com.runnablepatterns.proxyremotepattern;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface used to expose the methods that can be used by remote clients.
 */
public interface InvoicePreviewRemote extends Remote{
	/**
	 * Get the Agent handling the InvoicePreview
	 * @return Agent Name
	 * @throws RemoteException
	 */
	public String getAgentName() throws RemoteException;
	
	/**
	 * Get the terminal where the InvoicePreview is getting processed
	 * @return The terminal
	 * @throws RemoteException
	 */
	public String getTerminal() throws RemoteException;
	
	/**
	 * Get the current state of InvoicePreview by terminal
	 * @return The current state
	 * @throws RemoteException
	 */
	public MyState getCurrentState() throws RemoteException;
}
