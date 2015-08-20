package com.verint.probe.api.message.impl;

import org.springframework.stereotype.Service;

import com.verint.probe.api.message.IMessage;

@Service
public class CreateVA implements IMessage{
	
	
	@Override
	public String toString() {
		return "processing CreateVA ";
	}

	@Override
	public Object process(Object msg) {
		return "-Processing CreateVA .....";
	}

}
