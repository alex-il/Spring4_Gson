package com.verint.probe.api;


public interface IMessageProcessor {
	/**
	 * The process method process the request messages from EIM.
	 * It returns the response as response message. 
	 * The type of response according to request type.
	 * 
	 * @param request - the request message from EIM
	 * @param msgName - String message name according to Probe HLD.
	 * @return - response according to request type.
	 */
	public Object process(Object request, String msgName);

}
