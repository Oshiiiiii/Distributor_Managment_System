package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.DistributorDTO;

import java.util.List;

public interface DistributorService {

	DistributorDTO save(DistributorDTO dto);

	List<DistributorDTO> getList(int page, int limit);

	DistributorDTO get(Long id);

	void delete(Long id);

	DistributorDTO update(Long id, DistributorDTO dto);
}
