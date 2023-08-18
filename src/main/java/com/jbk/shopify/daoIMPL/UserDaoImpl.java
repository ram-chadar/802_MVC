package com.jbk.shopify.daoIMPL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.shopify.dao.UserDao;
import com.jbk.shopify.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Object loginProcess(User user) {
		
		String msg =null;
		try(Session session=sessionFactory.openSession()) {
			
			User dbUser = session.get(User .class, user.getUsername());
			if(dbUser!=null) {
				
				if(user.getPassword().equals(dbUser.getPassword())) {
					return dbUser;
				}else {
					msg="Invalid Password";
					return msg;
				}
			}else {
				msg="Invalid Username";
				return msg;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
