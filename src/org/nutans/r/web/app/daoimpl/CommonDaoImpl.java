package org.nutans.r.web.app.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutans.r.web.app.config.sendSMS;
import org.nutans.r.web.app.dao.CommonDao;
import org.nutans.r.web.app.dbconfig.HibernateTemplate;
import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.ChartData;
import org.nutans.r.web.app.model.Customer;
import org.nutans.r.web.app.model.CustomerRequest;
import org.nutans.r.web.app.model.Dashboard;
import org.nutans.r.web.app.model.DeviceFault;
import org.nutans.r.web.app.model.Messages;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDaoImpl implements CommonDao{

	@Override
	public List<DeviceFault> getFaults(DeviceFault deviceFault) throws NRPSupportException
	{
		return HibernateTemplate.getInstance().getList(DeviceFault.class);
	}
	
	@Override
	public List<CustomerRequest> getCusRequest() throws NRPSupportException
	{
		return HibernateTemplate.getInstance().getList(CustomerRequest.class);
	}
	
	@Override
	public List<CustomerRequest> addCusRequest(CustomerRequest customerRequest) throws NRPSupportException
	{
		if(HibernateTemplate.getInstance().save(customerRequest))
			return HibernateTemplate.getInstance().getList(CustomerRequest.class);
		throw new NRPSupportException("Unable to add new request!!!");	
	}
	
	@Override
	public List<CustomerRequest> updateCusRequest(CustomerRequest customerRequest) throws NRPSupportException
	{
		Map<String,Object> mapKeyValue =new HashMap<String,Object>();
		mapKeyValue.put("status", customerRequest.getStatus());
		mapKeyValue.put("customerRequestId", customerRequest.getCustomerRequestId());
		String queryCommand="update CustomerRequest set status=:status where customerRequestId=:customerRequestId";
		sendSMS.sendSms(" Dear Customer. Your request has been processed. Request status is " + customerRequest.getStatus(), customerRequest.getMobile());
		if(HibernateTemplate.getInstance().update(queryCommand, mapKeyValue))
			return HibernateTemplate.getInstance().getList(CustomerRequest.class);
		
		throw new NRPSupportException("Unable to add new request!!!");	
	}
	
	@Override
	public List<Messages> getMessages() throws NRPSupportException
	{
		return HibernateTemplate.getInstance().getList(Messages.class);
	}
	
	@Override
	public List<Customer> getCustomers() throws NRPSupportException
	{
		return HibernateTemplate.getInstance().getList(Customer.class);
	}
	
	@Override
	public Dashboard getDashboard() throws NRPSupportException
	{
		List<CustomerRequest>  customerRequests=HibernateTemplate.getInstance().getList(CustomerRequest.class);
		List<ChartData> chartDataLst=new ArrayList<ChartData>();
		Dashboard dashboard=new Dashboard();
		ChartData chartData=null;
		int totalCustomerReqCount=0,pendingCount=0,totalDeviceFaultCount=0,pendingDeviceFault=0;
		for(CustomerRequest customerRequest : customerRequests)
		{
			chartData=new ChartData();
			if(customerRequest.getStatus().equals("Pending"))
				pendingCount++;
			totalCustomerReqCount++;
		}
		dashboard.setChartData(chartDataLst);	
		dashboard.setPendingCount(pendingCount);
		dashboard.setTotalCustomerReqCount(totalCustomerReqCount);
		
		List<DeviceFault> deviceFaults=HibernateTemplate.getInstance().getList(DeviceFault.class);
		for(DeviceFault deviceFault : deviceFaults)
		{
			if(deviceFault.getFaultStatus().equals("Pending"))
				pendingDeviceFault++;
			totalDeviceFaultCount++;
		}
		dashboard.setTotalDeviceFaultCount(totalDeviceFaultCount);
		dashboard.setPendingDeviceFault(pendingDeviceFault);
		return dashboard;

	}
	
	public List<CustomerRequest> getCusRequest(Integer customerId) throws NRPSupportException
	{
		Map<String,Object> mapResponse=new HashMap<String,Object>();
		mapResponse.put("customer.customerId", customerId);
		return HibernateTemplate.getInstance().getListByFields(CustomerRequest.class,mapResponse);		
	}
}
