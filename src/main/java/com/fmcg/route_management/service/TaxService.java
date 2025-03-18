package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.TaxDTO;

public interface TaxService {

	TaxDTO save(TaxDTO dto);

	List<TaxDTO> getList(int page, int limit);

	TaxDTO get(Long id);

	void delete(Long id);

	TaxDTO update(Long id, TaxDTO dto);
}
