package com.swl.wallet.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swl.wallet.dao.TransactionDao;
import com.swl.wallet.dto.TransactionDTO;
import com.swl.wallet.model.Transaction;
import com.swl.wallet.service.convertor.TransactionConvertor;

/**
 * @author SanWaiLwin
 * 
 */
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	TransactionConvertor convertor = new TransactionConvertor();

	@Override
	public TransactionDTO save(TransactionDTO dto) {
		Transaction saveData = convertor.convertFromDTO(dto);
		saveData.setTransactionDate(new Date());
		Transaction entity = transactionDao.save(saveData);
		return convertor.convertToDTO(entity);
	}

	@Override
	public TransactionDTO getById(Long id) {
		Transaction entity = transactionDao.getOne(id);
		return convertor.convertToDTO(entity);
	}

}
