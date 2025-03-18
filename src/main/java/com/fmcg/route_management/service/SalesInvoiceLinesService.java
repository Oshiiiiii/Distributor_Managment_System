package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.SalesInvoiceLinesDTO;




public interface SalesInvoiceLinesService {

	SalesInvoiceLinesDTO save(SalesInvoiceLinesDTO dto);

	List<SalesInvoiceLinesDTO> getList(int page, int limit);

	SalesInvoiceLinesDTO get(Long id);

	void delete(Long id);

	SalesInvoiceLinesDTO update(Long id, SalesInvoiceLinesDTO dto);
}
