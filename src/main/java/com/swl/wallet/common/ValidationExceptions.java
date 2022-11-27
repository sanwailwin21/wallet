package com.swl.wallet.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.swl.wallet.util.FieldErrors;

/**
 * @author SanWaiLwin
 * 
 */
public abstract class ValidationExceptions {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Response<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<FieldErrors> errorList = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			errorList.add(new FieldErrors(error.getDefaultMessage()));
		});
		Response<FieldErrors> response = new Response<>();
		response.setErrorList(errorList);
		return response;
	}
}
