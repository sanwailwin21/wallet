package com.swl.wallet.api.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swl.wallet.api.request.BillRequest;
import com.swl.wallet.api.request.TransactionRequest;
import com.swl.wallet.api.response.BillResponse;
import com.swl.wallet.api.response.TransactionResponse;
import com.swl.wallet.common.Response;
import com.swl.wallet.common.ValidationExceptions;
import com.swl.wallet.dto.BillDTO;
import com.swl.wallet.dto.TransactionDTO;
import com.swl.wallet.service.BillService;
import com.swl.wallet.service.TransactionService;
import com.swl.wallet.util.CommonConstant;
import com.swl.wallet.util.CommonUtil;

/**
 * @author SanWaiLwin
 *
 */
@RestController
public class BillApiController extends ValidationExceptions {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private BillService billService;

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/add")
	public Response<?> addingBill(@Valid @RequestBody BillRequest request, HttpServletRequest req,
			HttpServletResponse resp) {
		logger.info("addingBill api start ........");
		Response<BillResponse> response = new Response<>();
		try {
			BillDTO dto = billService.save(new BillDTO(request.getName(), request.getDescription()));
			response.setData(new BillResponse().convertFromDto(dto));
			logger.info("addingBill api success ........");
		} catch (Exception e) {
			logger.info("General application exception occurred while processing addingBill api >>>>>>");
			e.printStackTrace();
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus_message("General application exception occurred while processing addingBill api >>>>>>");
		}
		return response;
	}

	@GetMapping("/list")
	public Response<?> getBillList(@RequestParam(name = "id") Long id, HttpServletRequest req,
			HttpServletResponse resp) {
		logger.info("getBillList api start ........");
		Response<?> response = new Response<>();
		try {
			List<BillResponse> bills = billService.getBillList(new BillDTO(id)).stream()
					.map(dto -> new BillResponse().prepareForBillResponse(dto)).collect(Collectors.toList());
			response.setBillers(bills);
			response.setStatus_message("Transaction is successful!");
			response.setDate_time(CommonUtil.dateToString(CommonConstant.STD_DATE_FORMAT, new Date()));
			logger.info("getBillList api success  ........");
		} catch (Exception e) {
			logger.info("General application exception occurred while processing getBillList api >>>>>>");
			e.printStackTrace();
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus_message(
					"General application exception occurred while processing getBillList api >>>>>>");
		}
		return response;
	}

	@PostMapping("/pay")
	public Response<?> payingBill(@Valid @RequestBody TransactionRequest request, HttpServletRequest req,
			HttpServletResponse resp) {
		logger.info("payingBill api start ........");
		Response<TransactionResponse> response = new Response<>();
		try {
			TransactionDTO dto = transactionService.save(new TransactionDTO().convertToDTO(request));
			response.setData(new TransactionResponse().convertFromDto(dto));
			logger.info("payingBill api success ........");
		} catch (Exception e) {
			logger.info("General application exception occurred while processing payingBill api >>>>>>");
			e.printStackTrace();
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus_message("General application exception occurred while processing payingBill api >>>>>>");
		}
		return response;
	}

	@GetMapping("/transaction")
	public Response<?> getTransactionById(@RequestParam(name = "id") Long id, HttpServletRequest req,
			HttpServletResponse resp) {
		logger.info("getTransactionById api start ........");
		Response<TransactionResponse> response = new Response<>();
		try { 
			TransactionDTO dto = transactionService.getById(id);
			response.setData(new TransactionResponse().convertFromDTOs(dto));
			logger.info("getBillList api success  ........");
		} catch (Exception e) {
			logger.info("General application exception occurred while processing getTransactionById api >>>>>>");
			e.printStackTrace();
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus_message(
					"General application exception occurred while processing getTransactionById api >>>>>>");
		}
		return response;
	}

}
