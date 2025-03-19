package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.TaxDTO;

import java.util.List;



public interface TaxService {

	TaxDTO save(TaxDTO dto);

	List<TaxDTO> getList(int page, int limit);

	TaxDTO get(Long id);

	void delete(Long id);

	TaxDTO update(Long id, TaxDTO dto);
}
