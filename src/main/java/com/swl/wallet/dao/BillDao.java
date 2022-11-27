package com.swl.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swl.wallet.model.Bill;

/**
 * @author SanWaiLwin
 *
 */
public interface BillDao extends JpaRepository<Bill, Long> {

}
