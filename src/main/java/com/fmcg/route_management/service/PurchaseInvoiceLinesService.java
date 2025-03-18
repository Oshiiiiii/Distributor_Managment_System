package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto. PurchaseInvoiceLinesDTO;

public interface PurchaseInvoiceLinesService {

	 PurchaseInvoiceLinesDTO save( PurchaseInvoiceLinesDTO dto);

	List< PurchaseInvoiceLinesDTO> getList(int page, int limit);

	 PurchaseInvoiceLinesDTO get(Long id);

	void delete(Long id);

	 PurchaseInvoiceLinesDTO update(Long id,  PurchaseInvoiceLinesDTO dto);
}
