package com.verint.webint.api.validator.impl;

import org.springframework.stereotype.Service;

import com.verint.probe.api.validator.IValidator;

@Service
public class ExeValidator implements IValidator {

	@Override
	public int validate() {
//		TODO
		System.out.println("  ExeValidator validating ...");
		return 0;
	}

}
