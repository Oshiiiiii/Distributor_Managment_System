package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto. PurchaseOrderDTO;

public interface PurchaseOrderService {

	 PurchaseOrderDTO save( PurchaseOrderDTO dto);

	List< PurchaseOrderDTO> getList(int page, int limit);

	 PurchaseOrderDTO get(Long id);

	void delete(Long id);

	 PurchaseOrderDTO update(Long id,  PurchaseOrderDTO dto);
}
