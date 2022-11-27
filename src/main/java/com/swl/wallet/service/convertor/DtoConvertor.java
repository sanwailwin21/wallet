package com.swl.wallet.service.convertor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SanWaiLwin
 * 
 */
public abstract class DtoConvertor<E, D> {

	public abstract D convertToDTO(E entity);

	public abstract E convertFromDTO(D dto);

	public List<D> convertToDTOList(List<E> list) {
		List<D> dtoList = new ArrayList<D>();
		for (E e : list) {
			dtoList.add(convertToDTO(e));
		}
		return dtoList;
	}

	public List<E> convertFromDTOList(List<D> studioList) {
		List<E> entityList = new ArrayList<E>();
		for (D d : studioList) {
			entityList.add(convertFromDTO(d));
		}
		return entityList;
	}

}
