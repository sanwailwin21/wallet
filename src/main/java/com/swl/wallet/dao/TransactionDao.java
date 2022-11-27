package com.swl.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swl.wallet.model.Transaction;

/**
 * @author SanWaiLwin
 * 
 */
public interface TransactionDao extends JpaRepository<Transaction, Long> {

}
