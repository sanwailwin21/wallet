package com.swl.wallet.dao;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swl.wallet.model.User;

/**
 * @author SanWaiLwin
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUserName(String username);

}
