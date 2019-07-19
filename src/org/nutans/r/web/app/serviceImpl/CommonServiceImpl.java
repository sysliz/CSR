package org.nutans.r.web.app.serviceImpl;

import java.util.List;

import org.nutans.r.web.app.dao.CommonDao;
import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.Customer;
import org.nutans.r.web.app.model.CustomerRequest;
import org.nutans.r.web.app.model.Dashboard;
import org.nutans.r.web.app.model.DeviceFault;
import org.nutans.r.web.app.model.Messages;
import org.nutans.r.web.app.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private CommonDao commonDao;
	
	@Override
	public List<DeviceFault> getFaults(DeviceFault deviceFault) throws NRPSupportException
	{
		try
		{
			List<DeviceFault> deviceFaults=commonDao.getFaults(deviceFault);
			if(deviceFaults!=null)
				return deviceFaults;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("No records found!!!");
	}
	
	@Override
	public List<CustomerRequest> getCusRequest() throws NRPSupportException
	{
		try
		{
			List<CustomerRequest> lstCustomerRequest=commonDao.getCusRequest();
			if(lstCustomerRequest!=null)
				return lstCustomerRequest;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("No records found!!!");	
	}
	
	@Override
	public List<CustomerRequest> addCusRequest(CustomerRequest customerRequest) throws NRPSupportException
	{
		try
		{
			List<CustomerRequest> lstCustomerRequest=commonDao.addCusRequest(customerRequest);
			if(lstCustomerRequest!=null)
				return lstCustomerRequest;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("Unable to add new request!!!");	
	}
	
	@Override
	public List<CustomerRequest> updateCusRequest(CustomerRequest customerRequest) throws NRPSupportException
	{
		try
		{
			List<CustomerRequest> lstCustomerRequest=commonDao.updateCusRequest(customerRequest);
			if(lstCustomerRequest!=null)
				return lstCustomerRequest;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("Unable to add new request!!!");	
	}
	
	@Override
	public List<Messages> getMessages() throws NRPSupportException
	{
		try
		{
			List<Messages> messages=commonDao.getMessages();
			if(messages!=null)
				return messages;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("No records found!!!");	
	}
	
	@Override
	public List<Customer> getCustomers() throws NRPSupportException
	{
		try
		{
			List<Customer> customers=commonDao.getCustomers();
			if(customers!=null)
				return customers;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("No records found!!!");	
	}
	
	@Override
	public Dashboard getDashboard() throws NRPSupportException
	{
		try
		{
			Dashboard dashboard  =commonDao.getDashboard();
			if(dashboard!=null)
				return dashboard;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("No records found!!!");		
	}
	
	public List<CustomerRequest> getCusRequest(Integer customerId) throws NRPSupportException
	{
		try
		{
			List<CustomerRequest> lstCustomerRequest=commonDao.getCusRequest(customerId);
			if(lstCustomerRequest!=null)
				return lstCustomerRequest;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("No records found!!!");		
	}

}
