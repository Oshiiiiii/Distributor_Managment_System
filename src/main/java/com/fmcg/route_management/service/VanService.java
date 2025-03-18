package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.VanDTO;



public interface VanService {

	VanDTO save(VanDTO dto);

	List<VanDTO> getList(int page, int limit);

	VanDTO get(Long id);

	void delete(Long id);

	VanDTO update(Long id, VanDTO dto);
}
