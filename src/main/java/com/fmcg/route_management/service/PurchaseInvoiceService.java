package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.PurchaseInvoiceDTO;

import java.util.List;


public interface PurchaseInvoiceService {

	 PurchaseInvoiceDTO save(PurchaseInvoiceDTO dto);

	List< PurchaseInvoiceDTO> getList(int page, int limit);

	 PurchaseInvoiceDTO get(Long id);

	void delete(Long id);

	 PurchaseInvoiceDTO update(Long id,  PurchaseInvoiceDTO dto);
}
