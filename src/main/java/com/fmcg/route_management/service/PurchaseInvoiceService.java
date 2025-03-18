package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto. PurchaseInvoiceDTO;

public interface PurchaseInvoiceService {

	 PurchaseInvoiceDTO save( PurchaseInvoiceDTO dto);

	List< PurchaseInvoiceDTO> getList(int page, int limit);

	 PurchaseInvoiceDTO get(Long id);

	void delete(Long id);

	 PurchaseInvoiceDTO update(Long id,  PurchaseInvoiceDTO dto);
}
