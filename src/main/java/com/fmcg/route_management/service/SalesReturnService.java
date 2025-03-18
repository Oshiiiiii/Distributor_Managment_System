package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.SalesReturnDTO;

public interface SalesReturnService {

	SalesReturnDTO save(SalesReturnDTO dto);

	List<SalesReturnDTO> getList(int page, int limit);

	SalesReturnDTO get(Long id);

	void delete(Long id);

	SalesReturnDTO update(Long id, SalesReturnDTO dto);
}
