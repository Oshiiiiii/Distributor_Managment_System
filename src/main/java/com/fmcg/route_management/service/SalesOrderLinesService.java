package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.SalesOrderLinesDTO;

import java.util.List;


public interface SalesOrderLinesService {

	SalesOrderLinesDTO save(SalesOrderLinesDTO dto);

	List<SalesOrderLinesDTO> getList(int page, int limit);

	SalesOrderLinesDTO get(Long id);

	void delete(Long id);

	SalesOrderLinesDTO update(Long id, SalesOrderLinesDTO dto);
}
