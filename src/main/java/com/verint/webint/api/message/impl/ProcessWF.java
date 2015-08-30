package com.verint.webint.api.message.impl;

import org.springframework.stereotype.Service;

import com.verint.probe.api.message.IMessage;

@Service
public class ProcessWF implements IMessage{
	
	public ProcessWF() {
		
	}
	
	@Override
	public String toString() {
		return "processing ProcessWF ";
	}

	@Override
	public Object process(Object msg) {
		return "-Processing ProcessWF .....";
	}

}
