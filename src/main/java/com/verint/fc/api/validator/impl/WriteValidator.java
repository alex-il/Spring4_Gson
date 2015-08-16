package com.verint.fc.api.validator.impl;

import org.springframework.stereotype.Service;

import com.verint.fc.api.validator.IValidator;

@Service
public class WriteValidator implements IValidator {

	@Override
	public int validate() {
//		TODO
		System.out.println("  WriteValidator validating ...");
		return 0;
	}

}
