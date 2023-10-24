package com.kh.test.customer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.mapper.CustomerMapper;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@Service

public class CustomerServiceiml implements CustomerService {

	@Autowired
	private CustomerMapper mapper;
	
	
	@Override
		public int signup(Customer inputCustomer) {
			return mapper.signup(inputCustomer);
		}
	
}
