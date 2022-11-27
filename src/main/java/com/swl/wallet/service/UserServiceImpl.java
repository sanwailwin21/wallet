package com.swl.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swl.wallet.dao.UserDao;
import com.swl.wallet.model.User;

/**
 * @author SanWaiLwin
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);

	}

}
