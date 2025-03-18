package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.PickListDTO;



public interface PickListService {

	PickListDTO save(PickListDTO dto);

	List<PickListDTO> getList(int page, int limit);

	PickListDTO get(Long id);

	void delete(Long id);

	PickListDTO update(Long id, PickListDTO dto);
}
