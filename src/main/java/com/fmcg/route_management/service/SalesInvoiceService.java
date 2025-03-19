package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.SalesInvoiceDTO;

import java.util.List;


public interface SalesInvoiceService {

	SalesInvoiceDTO save(SalesInvoiceDTO dto);

	List<SalesInvoiceDTO> getList(int page, int limit);

	SalesInvoiceDTO get(Long id);

	void delete(Long id);

	SalesInvoiceDTO update(Long id, SalesInvoiceDTO dto);
}
