package com.verint.probe.api.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.ALOAD;

/**
 * Created by OBranopolsky on 14/08/2015.
 */

@Service
public class MessageConfigLoader {

	private Messages msgConfig;
	private List<String> messageNames = new ArrayList<String>();

	public MessageConfigLoader() {
		Gson json = new Gson();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("Messages.json"));
			setMsgConfig(json.fromJson(br, Messages.class));
		} catch (FileNotFoundException e) {
			System.err.println("bad Messages.json");
			setMsgConfig(null);
		}
		List<XmlMessage> xmls = msgConfig.getXmlMessages();
		for (XmlMessage x : xmls) {
			messageNames.add(x.getName());
		}

		List<SoapMessage> soapMessages = msgConfig.getSoapMessages();
		for (SoapMessage s : soapMessages) {
			messageNames.add(s.getName());
		}
	}

	public boolean containMessage(String name) {
		return messageNames.contains(name);
	}

	public List<XmlMessage> getXmlMessages() {
		List<XmlMessage> xmls = msgConfig.getXmlMessages();
		return xmls;
	}

	public List<SoapMessage> getSoapMessages() {
		return msgConfig.getSoapMessages();
	}

	public static void main(String[] args) throws Exception {
		Gson msgConfig = new Gson();
		BufferedReader br = new BufferedReader(new FileReader("Messages.json"));

		// convert the json string back to object
		Messages messages = msgConfig.fromJson(br, Messages.class);
		System.out.println("--------");

		System.out.println("version:" + messages.getVersion());
		System.out.println("Name:" + messages.getName());
		System.out.println("--------");

		List<XmlMessage> xmls = messages.getXmlMessages();

		for (XmlMessage x : xmls) {
			System.out.println("name: " + x.getName());
			System.out.println("read T/O: " + x.getReatTO());
			System.out.println("write T/O: " + x.getWriteTO());

			List<String> validators = x.getValidators();
			int i = 0;
			for (String v : validators) {
				System.out.println(++i + ": " + v);
			}

			List<String> convertors = x.getConvertors();
			if (convertors != null) {
				System.out.println("Convertor:" + convertors);
			}

			List<String> executors = x.getExecutors();
			if (executors != null) {

				System.out.println("Executors: " + executors);
			}
			System.out.println("--------------\n");
		}

		List<SoapMessage> soapMessages = messages.getSoapMessages();
		if (soapMessages != null) {
			int i = 1;
			for (SoapMessage s : soapMessages) {
				System.out.println(i++ + ". soapMessage: " + s.getName());
			}
		}
		System.out.print("===END==");
	}

	public Messages getMsgConfig() {
		return msgConfig;
	}

	public void setMsgConfig(Messages msgConfig) {
		this.msgConfig = msgConfig;
	}

	public List<String> getValidators(String msgName) {
		List<XmlMessage> xmls = msgConfig.getXmlMessages();
		for (XmlMessage x : xmls) {
			if (x.getName().equals(msgName)) {
				return x.getValidators();
			}
		}
		return null;
	}

	public List<String> getConverters(String msgName) {
		List<XmlMessage> xmls = msgConfig.getXmlMessages();
		for (XmlMessage x : xmls) {
			if (x.getName().equals(msgName)) {
				return x.getConvertors();
			}
		}
		return null;
	}
	
}
