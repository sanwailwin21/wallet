package com.swl.wallet.service;

import com.swl.wallet.dto.TransactionDTO;

/**
 * @author SanWaiLwin
 * 
 */
public interface TransactionService {

	TransactionDTO save(TransactionDTO convertToDTO);

	TransactionDTO getById(Long id);

}
