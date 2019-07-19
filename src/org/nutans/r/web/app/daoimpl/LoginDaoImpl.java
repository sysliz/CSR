package org.nutans.r.web.app.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.nutans.r.web.app.dao.LoginDao;
import org.nutans.r.web.app.dbconfig.HibernateTemplate;
import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.model.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Override
	public UserDetails validate(UserDetails userdetails) throws NRPSupportException
	{
		Map<String,Object> mapKeyValue=new HashMap<String,Object>();
		mapKeyValue.put("userName", userdetails.getUserName());
		mapKeyValue.put("password", userdetails.getPassword());
		return  HibernateTemplate.getInstance().getByFields(UserDetails.class, mapKeyValue);
	}
	@Override
	public UserDetails forgot(UserDetails userdetails) throws NRPSupportException
	{
		Map<String,Object> mapKeyValue=new HashMap<String,Object>();
		mapKeyValue.put("email", userdetails.getEmail());
		return  HibernateTemplate.getInstance().getByFields(UserDetails.class, mapKeyValue);
	}
}
