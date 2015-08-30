package com.verint.webint.api.services;

import org.springframework.stereotype.Service;

/**
 * Spring bean
 * 
 */

@Service("aaa")
public class HelloWorld {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("From Spring # : Hello  " + name);
	}
}