package org.nutans.r.web.app.dao;

import java.util.List;

import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.Customer;
import org.nutans.r.web.app.model.CustomerRequest;
import org.nutans.r.web.app.model.Dashboard;
import org.nutans.r.web.app.model.DeviceFault;
import org.nutans.r.web.app.model.Messages;

public interface CommonDao {

	public List<DeviceFault> getFaults(DeviceFault deviceFault) throws NRPSupportException;

	public List<CustomerRequest> getCusRequest() throws NRPSupportException;
	
	public List<CustomerRequest> addCusRequest(CustomerRequest customerRequest) throws NRPSupportException;

	public List<Messages> getMessages() throws NRPSupportException;

	public List<Customer> getCustomers() throws NRPSupportException;

	public Dashboard getDashboard() throws NRPSupportException;

	public List<CustomerRequest> updateCusRequest(CustomerRequest customerRequest) throws NRPSupportException;
	
	public List<CustomerRequest> getCusRequest(Integer customerId) throws NRPSupportException;
}
