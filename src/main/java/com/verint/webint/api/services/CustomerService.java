package com.verint.webint.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verint.webint.api.dao.CustomerDAO;

@Service
public class CustomerService 
{
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public String toString() {
		return "CustomerService [customerDAO => " + customerDAO + "]";
	}
		
}
