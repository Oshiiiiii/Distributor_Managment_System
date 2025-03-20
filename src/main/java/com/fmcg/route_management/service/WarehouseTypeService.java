package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.WarehouseTypeDTO;

import java.util.List;

public interface WarehouseTypeService {

	WarehouseTypeDTO save(WarehouseTypeDTO dto);

	List<WarehouseTypeDTO> getList(int page, int limit);

	WarehouseTypeDTO get(Long id);

	void delete(Long id);

	WarehouseTypeDTO update(Long id, WarehouseTypeDTO dto);
}
