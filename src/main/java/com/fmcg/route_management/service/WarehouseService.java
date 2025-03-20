package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.WarehouseDTO;

import java.util.List;


public interface WarehouseService {

	WarehouseDTO save(WarehouseDTO dto);

	List<WarehouseDTO> getList(int page, int limit);

	WarehouseDTO get(Long id);

	void delete(Long id);

	WarehouseDTO update(Long id, WarehouseDTO dto);
}
