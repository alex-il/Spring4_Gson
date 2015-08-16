package com.verint.fc.api.message.impl;

import org.springframework.stereotype.Service;

import com.verint.fc.api.message.IMessage;

@Service
public class ProcessWF implements IMessage{
	
	public ProcessWF() {
		
	}
	
	@Override
	public String toString() {
		return "processing ProcessWF ";
	}

	@Override
	public int process() {
		System.out.println("-Processing ProcessWF .....");
		return 0;
	}

}
