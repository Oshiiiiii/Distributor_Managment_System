package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.PickListDTO;

import java.util.List;




public interface PickListService {

	PickListDTO save(PickListDTO dto);

	List<PickListDTO> getList(int page, int limit);

	PickListDTO get(Long id);

	void delete(Long id);

	PickListDTO update(Long id, PickListDTO dto);
}
