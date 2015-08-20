package com.verint.probe.api.validator.impl;

import org.springframework.stereotype.Service;

import com.verint.probe.api.validator.IValidator;

@Service
public class WriteValidator implements IValidator {

	@Override
	public int validate() {
//		TODO
		System.out.println("  WriteValidator validating ...");
		return 0;
	}

}
