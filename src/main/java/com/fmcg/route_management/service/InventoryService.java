package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.InventoryDTO;

import java.util.List;



public interface InventoryService {

	InventoryDTO save(InventoryDTO dto);

	List<InventoryDTO> getList(int page, int limit);

	InventoryDTO get(Long id);

	void delete(Long id);

	InventoryDTO update(Long id, InventoryDTO dto);
}
