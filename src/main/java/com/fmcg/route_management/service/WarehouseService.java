package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.WarehouseDTO;

public interface WarehouseService {

	WarehouseDTO save(WarehouseDTO dto);

	List<WarehouseDTO> getList(int page, int limit);

	WarehouseDTO get(Long id);

	void delete(Long id);

	WarehouseDTO update(Long id, WarehouseDTO dto);
}
