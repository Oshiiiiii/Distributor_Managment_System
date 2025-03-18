package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.SalesInvoiceDTO;

public interface SalesInvoiceService {

	SalesInvoiceDTO save(SalesInvoiceDTO dto);

	List<SalesInvoiceDTO> getList(int page, int limit);

	SalesInvoiceDTO get(Long id);

	void delete(Long id);

	SalesInvoiceDTO update(Long id, SalesInvoiceDTO dto);
}
