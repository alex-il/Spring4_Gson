package com.verint.fc.api.validator.impl;

import org.springframework.stereotype.Service;

import com.verint.fc.api.validator.IValidator;

@Service
public class ReadValidator implements IValidator {

	@Override
	public int validate() {
//		TODO
		System.out.println("  ReadValidator validating ...");
		return 0;
	}

}
