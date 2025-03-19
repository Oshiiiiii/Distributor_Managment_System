package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.SalesInvoiceLinesDTO;

import java.util.List;





public interface SalesInvoiceLinesService {

	SalesInvoiceLinesDTO save(SalesInvoiceLinesDTO dto);

	List<SalesInvoiceLinesDTO> getList(int page, int limit);

	SalesInvoiceLinesDTO get(Long id);

	void delete(Long id);

	SalesInvoiceLinesDTO update(Long id, SalesInvoiceLinesDTO dto);
}
