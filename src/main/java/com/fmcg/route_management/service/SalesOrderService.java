package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.SalesOrderDTO;

import java.util.List;



public interface SalesOrderService {

	SalesOrderDTO save(SalesOrderDTO dto);

	List<SalesOrderDTO> getList(int page, int limit);

	SalesOrderDTO get(Long id);

	void delete(Long id);

	SalesOrderDTO update(Long id, SalesOrderDTO dto);
}
