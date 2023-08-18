package com.jbk.shopify.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.shopify.dao.UserDao;
import com.jbk.shopify.entity.User;
import com.jbk.shopify.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public Object loginProcess(User user) {
		
		return dao.loginProcess(user);
	}

}
