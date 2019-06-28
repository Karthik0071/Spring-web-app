package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.getCurrentSession();
		
		Query<Customer> query=session.createQuery("FROM Customer order by last_name",Customer.class);
		
		List<Customer> customerList=query.getResultList();
		
		return customerList;
		
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		Session session1=sessionfactory.getCurrentSession();
		
		session1.saveOrUpdate(theCustomer);
				
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerid) {
		// TODO Auto-generated method stub
		
		Session session2=sessionfactory.getCurrentSession();
		
		Customer theCustomer=session2.get(Customer.class, customerid);
		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerid) {
		
		Session session3=sessionfactory.getCurrentSession();
		
		Customer temp=session3.get(Customer.class, customerid);
		
		session3.delete(temp);
		
	}

}
