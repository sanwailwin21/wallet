package com.swl.wallet.service.convertor;

import com.swl.wallet.dto.BillDTO;
import com.swl.wallet.model.Bill;
import com.swl.wallet.util.CommonUtil;

/**
 * @author SanWaiLwin
 *
 */
public class BillConvertor extends DtoConvertor<Bill, BillDTO> {

	@Override
	public BillDTO convertToDTO(Bill entity) {
		BillDTO dto = new BillDTO();
		if (entity != null) {
			if (CommonUtil.validLong(entity.getId())) {
				dto.setId(entity.getId());
			}
			if (CommonUtil.validString(entity.getName())) {
				dto.setName(entity.getName());
			}
			if (CommonUtil.validString(entity.getDescription())) {
				dto.setDescription(entity.getDescription());
			}
		}
		return dto;
	}

	@Override
	public Bill convertFromDTO(BillDTO dto) {
		Bill entity = new Bill();
		if (dto != null) {
			if (CommonUtil.validLong(dto.getId())) {
				entity.setId(dto.getId());
			}
			if (CommonUtil.validString(dto.getName())) {
				entity.setName(dto.getName());
			}
			if (CommonUtil.validString(dto.getDescription())) {
				entity.setDescription(dto.getDescription());
			}
		}
		return entity; 
	}

}
