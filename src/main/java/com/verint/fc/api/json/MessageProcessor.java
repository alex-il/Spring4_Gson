package com.verint.fc.api.json;

import java.util.List;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verint.fc.api.ApiMain;
import com.verint.fc.api.convert.IConverter;
import com.verint.fc.api.message.IMessage;
import com.verint.fc.api.validator.IValidator;

/**
 * Created by OBranopolsky on 14/08/2015.
 */

@Service
public class MessageProcessor {

	@Autowired
	XmlMessage xmlMessage;

	@Autowired
	SoapMessage soapMessage;

	@Autowired
	MessageConfigLoader msgConf;

	// public MessageProcessor() {
	// System.out.println("MessageProcessor: ctor ");
	// }

	public void process(String msgName) {

		String errorMsg = msgName;
		if (msgConf.containMessage(msgName)) {
			try {
				IMessage m = (IMessage) ApiMain.getBean(msgName);

				List<String> validators = msgConf.getValidators(msgName);

				for (String v : validators) {
					try {
						IValidator validator = (IValidator) ApiMain.getBean(v);
						validator.validate();
					} catch (NoSuchBeanDefinitionException e) {
						// e.printStackTrace();
						System.out.println("... " + v + " validator  have not implemented yet.");
					}
				}

				List<String> converter = msgConf.getConverters(msgName);

				for (String v : converter) {
					try {
						IConverter c = (IConverter) ApiMain.getBean(v);
						c.convert();
					} catch (NoSuchBeanDefinitionException e) {
						// e.printStackTrace();
						System.out.println("... " + v + " converter have not implemented yet.");
					}
				}

				m.process();
			} catch (NoSuchBeanDefinitionException e) {
				// e.printStackTrace();
				System.out.println("... " + errorMsg + " have not implemented yet.");
			}

		} else {
			System.out.println("... " + msgName + " message type does not defined in configuration");
		}

	}
}
