package org.nutans.r.web.app.dbconfig;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.nutans.r.web.app.exceptions.NRPSupportException;
import org.nutans.r.web.app.utils.ExceptionCode;

public class HibernateTemplate {

	private static HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate() {
		super();
	}
	
	 public static HibernateTemplate getInstance() {    
         if (hibernateTemplate==null)  
        	 hibernateTemplate=new  HibernateTemplate();  
         return hibernateTemplate;  
	 }  
	public boolean save(Object objectType) 
	{
		Transaction transaction=null;
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			transaction=session.beginTransaction();
			session.save(objectType);
			transaction.commit();
			return true;
		}
		catch(Exception save)
		{
			transaction.rollback();
			return false;
		}
		finally
		{
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public  <T> List<T> getList(Class<T> className) throws NRPSupportException
	{
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Query query=session.createQuery("from " + className.getName());
			return query.list();
		}
		catch(Exception save)
		{
			throw new NRPSupportException(ExceptionCode.No_records_in_the_card_list.toString());
		}
		finally
		{
			closeSession(session);
		}
	}
	@SuppressWarnings("unchecked")
	public  <T> List<T> getMasterList(Class<T> className) throws NRPSupportException
	{
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Query query=session.createQuery("from " + className.getName());
			return query.list();
		}
		catch(Exception save)
		{
			throw new NRPSupportException(ExceptionCode.No_records_in_the_card_list.toString());
		}
		finally
		{
			closeSession(session);
		}
	}
	@SuppressWarnings("unchecked")
	public  <T> List<T> getListByFields(Class<T> className,Map<String,Object> mapKeyValue) throws NRPSupportException
	{
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(className);
			for(Map.Entry<String, Object> oMapKeyValue : mapKeyValue.entrySet())
				criteria.add(Restrictions.eq(oMapKeyValue.getKey(), oMapKeyValue.getValue()));
			return criteria.list();
		}
		catch(Exception save)
		{
			throw new NRPSupportException(ExceptionCode.No_records_in_the_card_list.toString());
		}
		finally
		{
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public  <T> List<T> getListByFieldsRequ(Class<T> className,Map<String,Object> mapKeyValue) throws NRPSupportException
	{
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(className);
			for(Map.Entry<String, Object> oMapKeyValue : mapKeyValue.entrySet())
				criteria.add(Restrictions.eq(oMapKeyValue.getKey(), oMapKeyValue.getValue()));
			criteria.createAlias("customerRequestId", "customerRequestId");
			criteria.addOrder(Order.desc("customerRequestId"));
			return criteria.list();
		}
		catch(Exception save)
		{
			throw new NRPSupportException(ExceptionCode.No_records_in_the_card_list.toString());
		}
		finally
		{
			closeSession(session);
		}
	}
	@SuppressWarnings("unchecked")
	public  <T> T getByFields(Class<T> className,Map<String,Object> mapKeyValue) throws NRPSupportException
	{
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(className);
			for(Map.Entry<String, Object> oMapKeyValue : mapKeyValue.entrySet())
				criteria.add(Restrictions.eq(oMapKeyValue.getKey(), oMapKeyValue.getValue()));
			
			return (T) criteria.uniqueResult();
		}
		catch(Exception save)
		{
			System.out.println(save.getMessage());
		}
		finally
		{
			closeSession(session);
		}
		throw new NRPSupportException(ExceptionCode.No_records_in_the_card_list.toString());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T  getByQuery(Class<T> className,String queryCommand,Map<String,Object> mapKeyValue) throws NRPSupportException
	{
		T entityObject=null;
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Query query=session.createQuery(queryCommand);
			for(Map.Entry<String, Object> oMapKeyValue : mapKeyValue.entrySet())
				query.setParameter(oMapKeyValue.getKey(),oMapKeyValue.getValue());
			
			List<T> list=(List<T>)query.list();
			if(list!=null)
				entityObject=list.get(0);
		}
		catch(Exception save)
		{
			//throw new FareException();
		}
		finally
		{
			closeSession(session);
		}
		return entityObject;
	}
	@SuppressWarnings("unchecked")
	public <T> List<T>  getListByQuery(String queryCommand,Map<String,Object> mapKeyValue) throws NRPSupportException
	{
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Query query=session.createQuery(queryCommand);
			for(Map.Entry<String, Object> oMapKeyValue : mapKeyValue.entrySet())
				query.setParameter(oMapKeyValue.getKey(),oMapKeyValue.getValue());
			
			return (List<T>)query.list();
		}
		catch(Exception save)
		{
			save.printStackTrace();
		}
		finally
		{
			closeSession(session);
		}
		return null;
	}
	public boolean update(String queryCommand,Map<String,Object> mapKeyValue)
	{

		Transaction transaction=null;
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(queryCommand);
			for(Map.Entry<String, Object> oMapKeyValue : mapKeyValue.entrySet())
				query.setParameter(oMapKeyValue.getKey(),oMapKeyValue.getValue());
			query.executeUpdate();
			transaction.commit();
			return true;
		}
		catch(Exception save)
		{
			transaction.rollback();
		}
		return false;
	}
	
	public <T> boolean updateEntity(Object entityObject)
	{

		Transaction transaction=null;
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			transaction=session.beginTransaction();
			session.merge(entityObject);
			transaction.commit();
			return true;
		}
		catch(Exception save)
		{
			transaction.rollback();
		}
		return false;
	}
	public <T> boolean deleteEntity(String className,String pkColumnId,int pkId)
	{

		Transaction transaction=null;
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery("Update " + className + " set isDelete=1 where " + pkColumnId + "=:pkId");
			query.setParameter("pkId", pkId);
			query.executeUpdate();
			transaction.commit();
			return true;
		}
		catch(Exception save)
		{
			transaction.rollback();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public  <T> List<T> getListRequ(Class<T> className) throws NRPSupportException
	{
		Session session=null;
		try
		{
			session=HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			Query query=session.createQuery("from " + className.getName() + " order by customerRequestId desc");
			return query.list();
		}
		catch(Exception save)
		{
			throw new NRPSupportException(ExceptionCode.No_records_in_the_card_list.toString());
		}
		finally
		{
			closeSession(session);
		}
	}
	
	private void closeSession(Session session)
	{
		if(session!=null && session.isOpen())
		{
			session.flush();
			session.clear();
			session.close();
		}
	}
}
