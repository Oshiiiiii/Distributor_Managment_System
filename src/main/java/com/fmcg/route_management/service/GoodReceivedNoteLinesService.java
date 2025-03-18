package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.GoodReceivedNoteLinesDTO;

import java.util.List;



public interface GoodReceivedNoteLinesService {

	GoodReceivedNoteLinesDTO save(GoodReceivedNoteLinesDTO dto);

	List<GoodReceivedNoteLinesDTO> getList(int page, int limit);

	GoodReceivedNoteLinesDTO get(Long id);

	void delete(Long id);

	GoodReceivedNoteLinesDTO update(Long id, GoodReceivedNoteLinesDTO dto);
}
