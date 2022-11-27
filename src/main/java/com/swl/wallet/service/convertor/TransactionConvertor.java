package com.swl.wallet.service.convertor;

import com.swl.wallet.dto.TransactionDTO;
import com.swl.wallet.model.Transaction;
import com.swl.wallet.util.CommonConstant;
import com.swl.wallet.util.CommonUtil;

/**
 * @author SanWaiLwin
 * 
 */
public class TransactionConvertor extends DtoConvertor<Transaction, TransactionDTO> {

	BillConvertor billConvertor = new BillConvertor();

	@Override
	public TransactionDTO convertToDTO(Transaction entity) {
		TransactionDTO dto = new TransactionDTO();
		if (entity != null) {
			if (CommonUtil.validLong(entity.getId())) {
				dto.setId(entity.getId());
			}
			if (CommonUtil.validString(entity.getApiCaller())) {
				dto.setApiCaller(entity.getApiCaller());
			}
			if (entity.getBill() != null && CommonUtil.validLong(entity.getBill().getId())) {
				dto.setBillDto(billConvertor.convertToDTO(entity.getBill()));
			}
			if (CommonUtil.validBigDecimal(entity.getAmount())) {
				dto.setAmount(entity.getAmount());
			}
			if (CommonUtil.validString(entity.getReferenceNo())) {
				dto.setReferenceNo(entity.getReferenceNo());
			}
			if (CommonUtil.validString(entity.getPhoneNo())) {
				dto.setPhoneNo(entity.getPhoneNo());
			}
			if (CommonUtil.validDate(entity.getTransactionDate())) {
				dto.setTransactionDate(
						CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, entity.getTransactionDate()));
			}
		}
		return dto;
	}

	@Override
	public Transaction convertFromDTO(TransactionDTO dto) {
		Transaction entity = new Transaction();
		if (dto != null) {
			if (CommonUtil.validLong(dto.getId())) {
				entity.setId(dto.getId());
			}
			if (CommonUtil.validString(dto.getApiCaller())) {
				entity.setApiCaller(dto.getApiCaller());
			}
			if (null != dto.getBillDto() && CommonUtil.validLong(dto.getBillDto().getId())) {
				entity.setBill(billConvertor.convertFromDTO(dto.getBillDto()));
			}
			if (CommonUtil.validBigDecimal(dto.getAmount())) {
				entity.setAmount(dto.getAmount());
			}
			if (CommonUtil.validString(dto.getReferenceNo())) {
				entity.setReferenceNo(dto.getReferenceNo());
			}
			if (CommonUtil.validString(dto.getPhoneNo())) {
				entity.setPhoneNo(dto.getPhoneNo());
			}
			if (CommonUtil.validString(dto.getTransactionDate())) {
				entity.setTransactionDate(
						CommonUtil.stringToDate(CommonConstant.STD_DATE_TIME_FORMAT, dto.getTransactionDate()));
			}
		}
		return entity;
	}

}
