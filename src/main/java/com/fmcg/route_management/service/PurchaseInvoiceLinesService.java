package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.PurchaseInvoiceLinesDTO;

import java.util.List;


public interface PurchaseInvoiceLinesService {

	 PurchaseInvoiceLinesDTO save( PurchaseInvoiceLinesDTO dto);

	List<PurchaseInvoiceLinesDTO> getList(int page, int limit);

	 PurchaseInvoiceLinesDTO get(Long id);

	void delete(Long id);

	 PurchaseInvoiceLinesDTO update(Long id,  PurchaseInvoiceLinesDTO dto);
}
