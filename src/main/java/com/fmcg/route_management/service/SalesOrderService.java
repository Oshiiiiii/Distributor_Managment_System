package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.SalesOrderDTO;



public interface SalesOrderService {

	SalesOrderDTO save(SalesOrderDTO dto);

	List<SalesOrderDTO> getList(int page, int limit);

	SalesOrderDTO get(Long id);

	void delete(Long id);

	SalesOrderDTO update(Long id, SalesOrderDTO dto);
}
