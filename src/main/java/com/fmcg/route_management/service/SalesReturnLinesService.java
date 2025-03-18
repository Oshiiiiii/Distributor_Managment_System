package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.SalesReturnLinesDTO;



public interface SalesReturnLinesService {

	SalesReturnLinesDTO save(SalesReturnLinesDTO dto);

	List<SalesReturnLinesDTO> getList(int page, int limit);

	SalesReturnLinesDTO get(Long id);

	void delete(Long id);

	SalesReturnLinesDTO update(Long id, SalesReturnLinesDTO dto);
}
