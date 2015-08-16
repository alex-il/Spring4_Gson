package com.verint.fc.api.message.impl;

import org.springframework.stereotype.Service;

import com.verint.fc.api.message.IMessage;

@Service
public class CreateVA implements IMessage{
	
	
	@Override
	public String toString() {
		return "processing CreateVA ";
	}

	@Override
	public int process() {
		System.out.println("-Processing CreateVA .....");
		return 0;
	}

}
