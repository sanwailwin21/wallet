package com.swl.wallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swl.wallet.dao.BillDao;
import com.swl.wallet.dto.BillDTO;
import com.swl.wallet.model.Bill;
import com.swl.wallet.service.convertor.BillConvertor;

/**
 * @author SanWaiLwin
 *
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;

	BillConvertor convertor = new BillConvertor();

	@Override
	public List<BillDTO> getBillList(BillDTO dto) {
		return convertor.convertToDTOList(billDao.findAll());
	}

	@Override
	public BillDTO save(BillDTO billDTO) {
		Bill entity = billDao.save(convertor.convertFromDTO(billDTO));
		return convertor.convertToDTO(entity);
	}

}
