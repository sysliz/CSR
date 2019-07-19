package org.nutans.r.web.app.controller.rest;

import java.util.List;

import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.Customer;
import org.nutans.r.web.app.model.CustomerRequest;
import org.nutans.r.web.app.model.Dashboard;
import org.nutans.r.web.app.model.DeviceFault;
import org.nutans.r.web.app.model.Messages;
import org.nutans.r.web.app.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/fault/get", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<List<DeviceFault>> faults(@RequestBody DeviceFault deviceFault) throws NRPSupportException
	{
		return new ResponseEntity<List<DeviceFault>>(commonService.getFaults(deviceFault),HttpStatus.OK);
	}
	
	@RequestMapping(value="/cusrequest/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<List<CustomerRequest>> cusRequest() throws NRPSupportException
	{
		return new ResponseEntity<List<CustomerRequest>>(commonService.getCusRequest(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/cusrequest/add", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<List<CustomerRequest>> addCusRequest(@RequestBody CustomerRequest customerRequest) throws NRPSupportException
	{
		return new ResponseEntity<List<CustomerRequest>>(commonService.addCusRequest(customerRequest),HttpStatus.OK);
	}
	
	@RequestMapping(value="/cusrequest/update", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<List<CustomerRequest>> updateCusRequest(@RequestBody CustomerRequest customerRequest) throws NRPSupportException
	{
		return new ResponseEntity<List<CustomerRequest>>(commonService.updateCusRequest(customerRequest),HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<List<Customer>> Customer() throws NRPSupportException
	{
		return new ResponseEntity<List<Customer>>(commonService.getCustomers(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/messages/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<List<Messages>> messages() throws NRPSupportException
	{
		return new ResponseEntity<List<Messages>>(commonService.getMessages(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/dashboard/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Dashboard> dashboard() throws NRPSupportException
	{
		return new ResponseEntity<Dashboard>(commonService.getDashboard(),HttpStatus.OK);
	}

	@RequestMapping(value="/cusrequest/get/{customerId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<List<CustomerRequest>> cusRequestById(@PathVariable("customerId") Integer customerId) throws NRPSupportException
	{
		return new ResponseEntity<List<CustomerRequest>>(commonService.getCusRequest(customerId),HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> errorHandler(NRPSupportException nrpSupportException)
	{
		return new ResponseEntity<String>(nrpSupportException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
