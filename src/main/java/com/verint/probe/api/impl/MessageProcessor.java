package com.verint.probe.api.impl;

import java.util.List;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verint.probe.api.ApiUtil;
import com.verint.probe.api.IMessageProcessor;
import com.verint.probe.api.convert.IConverter;
import com.verint.probe.api.json.MessageConfigLoader;
import com.verint.probe.api.json.SoapMessage;
import com.verint.probe.api.json.XmlMessage;
import com.verint.probe.api.message.IMessage;
import com.verint.probe.api.validator.IValidator;

/**
 * Created by OBranopolsky on 14/08/2015.
 */

@Service
public class MessageProcessor implements IMessageProcessor {

	@Autowired
	XmlMessage xmlMessage;

	@Autowired
	SoapMessage soapMessage;

	@Autowired
	MessageConfigLoader msgConf;

	public Object process(Object request, String msgName) {

		String errorMsg = msgName;
		Object retObj = null;
		if (msgConf.containMessage(msgName)) {
			try {
				IMessage m = (IMessage) ApiUtil.getBean(msgName);

//			Validator processor
				List<String> validators = msgConf.getValidators(msgName);
				for (String v : validators) {
					try {
						IValidator validator = (IValidator) ApiUtil.getBean(v);
						validator.validate();
					} catch (NoSuchBeanDefinitionException e) {
						// e.printStackTrace();
						System.out.println("... " + v + " validator  have not implemented yet.");
					}
				}

//			Converter processor				
				List<String> converter = msgConf.getConverters(msgName);
				for (String v : converter) {
					try {
						IConverter c = (IConverter) ApiUtil.getBean(v);
						c.convert();
					} catch (NoSuchBeanDefinitionException e) {
						// e.printStackTrace();
						System.out.println("... " + v + " converter have not implemented yet.");
					}
				}

				retObj = m.process(request);
			} catch (NoSuchBeanDefinitionException e) {
				// e.printStackTrace();
				System.out.println("... " + errorMsg + " have not implemented yet.");
			}

		} else {
			System.out.println("... " + msgName + " message type does not defined in configuration");
		}
		System.out.println("retObj: "+retObj+"\n");
		return retObj;

	}
}
