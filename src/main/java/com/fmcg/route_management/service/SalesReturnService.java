package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.SalesReturnDTO;

import java.util.List;


public interface SalesReturnService {

	SalesReturnDTO save(SalesReturnDTO dto);

	List<SalesReturnDTO> getList(int page, int limit);

	SalesReturnDTO get(Long id);

	void delete(Long id);

	SalesReturnDTO update(Long id, SalesReturnDTO dto);
}
