package com.verint.fc.api.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;

/**
 * Created by OBranopolsky on 14/08/2015.
 */
public class MessageProcessor {

	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader("Messages.json"));

		// convert the json string back to object
		Messages messages = gson.fromJson(br, Messages.class);
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
				System.out.println(i++ + ". soapMessage: "+ s.getName());
			}
		}
		System.out.print("===END==");
	}

}
