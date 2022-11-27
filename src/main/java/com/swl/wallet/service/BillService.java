package com.swl.wallet.service; 

import java.util.List;

import com.swl.wallet.dto.BillDTO;

/**
 * @author SanWaiLwin
 *
 */
public interface BillService {

	List<BillDTO> getBillList(BillDTO billDTO);

	BillDTO save(BillDTO billDTO); 

}
