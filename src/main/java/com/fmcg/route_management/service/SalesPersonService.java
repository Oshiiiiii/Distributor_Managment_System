package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.SalesPersonDTO;



public interface SalesPersonService {

	SalesPersonDTO save(SalesPersonDTO dto);

	List<SalesPersonDTO> getList(int page, int limit);

	SalesPersonDTO get(Long id);

	void delete(Long id);

	SalesPersonDTO update(Long id, SalesPersonDTO dto);
}
