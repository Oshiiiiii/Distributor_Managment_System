package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.PurchaseOrderDTO;

import java.util.List;


public interface PurchaseOrderService {

	 PurchaseOrderDTO save(PurchaseOrderDTO dto);

	List< PurchaseOrderDTO> getList(int page, int limit);

	 PurchaseOrderDTO get(Long id);

	void delete(Long id);

	 PurchaseOrderDTO update(Long id,  PurchaseOrderDTO dto);
}
