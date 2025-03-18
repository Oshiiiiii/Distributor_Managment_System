package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto. PurchaseReturnDTO;

public interface PurchaseReturnService {

	 PurchaseReturnDTO save( PurchaseReturnDTO dto);

	List< PurchaseReturnDTO> getList(int page, int limit);

	 PurchaseReturnDTO get(Long id);

	void delete(Long id);

	 PurchaseReturnDTO update(Long id,  PurchaseReturnDTO dto);
}
