package org.nutans.r.web.app.controller.rest;

import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.UserDetails;
import org.nutans.r.web.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private LoginService LoginService;
	
	@RequestMapping(value="/validate", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> validate(@RequestBody UserDetails userdetails) throws NRPSupportException
	{
		UserDetails validateUserdetails=LoginService.validate(userdetails);
		return new ResponseEntity<UserDetails>(validateUserdetails,HttpStatus.OK);
	}
	
	@RequestMapping(value="/forgot", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> forgot(@RequestBody UserDetails userdetails) throws NRPSupportException
	{
		return new ResponseEntity<UserDetails>(LoginService.forgot(userdetails),HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> errorHandler(NRPSupportException nrpSupportException)
	{
		return new ResponseEntity<String>(nrpSupportException.getMessage(),HttpStatus.NOT_FOUND);
	}
}
