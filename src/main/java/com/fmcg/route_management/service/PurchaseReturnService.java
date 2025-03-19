package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.PurchaseReturnDTO;

import java.util.List;


public interface PurchaseReturnService {

	 PurchaseReturnDTO save( PurchaseReturnDTO dto);

	List<PurchaseReturnDTO> getList(int page, int limit);

	 PurchaseReturnDTO get(Long id);

	void delete(Long id);

	 PurchaseReturnDTO update(Long id,  PurchaseReturnDTO dto);
}
