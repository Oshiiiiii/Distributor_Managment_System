package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.WarehouseTypeDTO;

public interface WarehouseTypeService {

	WarehouseTypeDTO save(WarehouseTypeDTO dto);

	List<WarehouseTypeDTO> getList(int page, int limit);

	WarehouseTypeDTO get(Long id);

	void delete(Long id);

	WarehouseTypeDTO update(Long id, WarehouseTypeDTO dto);
}
