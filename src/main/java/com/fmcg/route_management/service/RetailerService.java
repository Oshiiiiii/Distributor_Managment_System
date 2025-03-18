package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.RetailerDTO;

public interface RetailerService {

	RetailerDTO save(RetailerDTO dto);

	List<RetailerDTO> getList(int page, int limit);

	RetailerDTO get(Long id);

	void delete(Long id);

	RetailerDTO update(Long id, RetailerDTO dto);
}
