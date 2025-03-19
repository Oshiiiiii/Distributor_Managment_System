package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.SalesPersonDTO;

import java.util.List;




public interface SalesPersonService {

	SalesPersonDTO save(SalesPersonDTO dto);

	List<SalesPersonDTO> getList(int page, int limit);

	SalesPersonDTO get(Long id);

	void delete(Long id);

	SalesPersonDTO update(Long id, SalesPersonDTO dto);
}
