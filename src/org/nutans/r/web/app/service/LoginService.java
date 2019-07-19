package org.nutans.r.web.app.service;

import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.UserDetails;

public interface LoginService {

	public UserDetails validate(UserDetails userdetails) throws NRPSupportException;
	
	public UserDetails forgot(UserDetails userdetails) throws NRPSupportException;
	
}
