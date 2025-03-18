package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.DistributorDTO;

public interface DistributorService {

	DistributorDTO save(DistributorDTO dto);

	List<DistributorDTO> getList(int page, int limit);

	DistributorDTO get(Long id);

	void delete(Long id);

	DistributorDTO update(Long id, DistributorDTO dto);
}
