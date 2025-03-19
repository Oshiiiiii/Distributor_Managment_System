package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.RetailerDTO;

import java.util.List;


public interface RetailerService {

	RetailerDTO save(RetailerDTO dto);

	List<RetailerDTO> getList(int page, int limit);

	RetailerDTO get(Long id);

	void delete(Long id);

	RetailerDTO update(Long id, RetailerDTO dto);
}
