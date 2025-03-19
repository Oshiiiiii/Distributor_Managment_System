package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.GoodReceivedNoteDTO;

import java.util.List;



public interface GoodReceivedNoteService {

	GoodReceivedNoteDTO save(GoodReceivedNoteDTO dto);

	List<GoodReceivedNoteDTO> getList(int page, int limit);

	GoodReceivedNoteDTO get(Long id);

	void delete(Long id);

	GoodReceivedNoteDTO update(Long id, GoodReceivedNoteDTO dto);
}
