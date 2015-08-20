package com.verint.probe.api.convert.impl;

import org.springframework.stereotype.Service;

import com.verint.probe.api.convert.IConverter;

@Service
public class VovaConverter implements IConverter {

	@Override
	public int convert() {
		// TODO Auto-generated method stub
		System.out.println("  ~--->>> VovaConverter converting...");
		return 0;
	}

}
