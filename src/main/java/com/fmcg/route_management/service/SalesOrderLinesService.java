package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.SalesOrderLinesDTO;


public interface SalesOrderLinesService {

	SalesOrderLinesDTO save(SalesOrderLinesDTO dto);

	List<SalesOrderLinesDTO> getList(int page, int limit);

	SalesOrderLinesDTO get(Long id);

	void delete(Long id);

	SalesOrderLinesDTO update(Long id, SalesOrderLinesDTO dto);
}
