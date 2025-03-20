package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.VanDTO;

import java.util.List;




public interface VanService {

	VanDTO save(VanDTO dto);

	List<VanDTO> getList(int page, int limit);

	VanDTO get(Long id);

	void delete(Long id);

	VanDTO update(Long id, VanDTO dto);
}
