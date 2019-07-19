package org.nutans.r.web.app.serviceImpl;

import org.nutans.r.web.app.dao.LoginDao;
import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.UserDetails;
import org.nutans.r.web.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public UserDetails validate(UserDetails userdetails) throws NRPSupportException
	{
		try
		{
			UserDetails dbUserdetails=loginDao.validate(userdetails);
			if(dbUserdetails!=null)
				return dbUserdetails;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		throw new NRPSupportException("Invalid credentials!!!");
	}
	
	@Override
	public UserDetails forgot(UserDetails userdetails) throws NRPSupportException
	{
		try
		{
			UserDetails dbUserdetails=loginDao.forgot(userdetails);
			if(dbUserdetails!=null)
			{
				
			}
			else
				throw new NRPSupportException("Invalid Email address!!!");
			return dbUserdetails;
		}
		catch(Exception exp)
		{
			throw new NRPSupportException("Server Error");
		}
		
	}
}
