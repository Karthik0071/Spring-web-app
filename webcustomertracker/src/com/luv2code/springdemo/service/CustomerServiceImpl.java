package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		List<Customer> listCustomers=customerDAO.getCustomers();
		return listCustomers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerid) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(customerid);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerid) {
		// TODO Auto-generated method stub
		
		customerDAO.deleteCustomer(customerid);
	}

}
