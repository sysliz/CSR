package org.nutans.r.web.app.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageRedirect {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login()
	{
		return "index";
	}
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String dashBoard()
	{
		return "dashboard";
	}
	
	@RequestMapping(value="/faults", method = RequestMethod.GET)
	public String faults()
	{
		return "faults";
	}
	
	@RequestMapping(value="/cusrequest", method = RequestMethod.GET)
	public String cusrequest()
	{
		return "cusrequest";
	}
	
	@RequestMapping(value="/messages", method = RequestMethod.GET)
	public String messages()
	{
		return "messages";
	}
	
	@RequestMapping(value="/servermonitor", method = RequestMethod.GET)
	public String servermonitor()
	{
		return "servermonitor";
	}
	
	@RequestMapping(value="/customer", method = RequestMethod.GET)
	public String customer()
	{
		return "customer";
	}
}
