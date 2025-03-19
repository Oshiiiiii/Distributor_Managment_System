package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.SalesReturnLinesDTO;

import java.util.List;


public interface SalesReturnLinesService {

	SalesReturnLinesDTO save(SalesReturnLinesDTO dto);

	List<SalesReturnLinesDTO> getList(int page, int limit);

	SalesReturnLinesDTO get(Long id);

	void delete(Long id);

	SalesReturnLinesDTO update(Long id, SalesReturnLinesDTO dto);
}
