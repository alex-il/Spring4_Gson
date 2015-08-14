package com.verint.fc.api.json;

import java.util.List;

/**
 * Created by OBranopolsky on 14/08/2015.
 */

public class Messages {

	private String name;
	private int version;
	private int readTO;
	private int writeTO;
	private List<XmlMessage> xmlMessages;
	private List<SoapMessage> soapMessages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public int getReadTO() {
		return readTO;
	}

	public void setReadTO(int readTO) {
		this.readTO = readTO;
	}

	public int getWriteTO() {
		return writeTO;
	}

	public void setWriteTO(int writeTO) {
		this.writeTO = writeTO;
	}

	public List<XmlMessage> getXmlMessages() {
		return xmlMessages;
	}

	public void setXmlMessages(List<XmlMessage> xmlMessages) {
		this.xmlMessages = xmlMessages;
	}

	public List<SoapMessage> getSoapMessages() {
		return soapMessages;
	}

	public void setSoapMessages(List<SoapMessage> soapMessages) {
		this.soapMessages = soapMessages;
	}

}