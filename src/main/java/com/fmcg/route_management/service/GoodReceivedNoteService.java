package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.GoodReceivedNoteDTO;

public interface GoodReceivedNoteService {

	GoodReceivedNoteDTO save(GoodReceivedNoteDTO dto);

	List<GoodReceivedNoteDTO> getList(int page, int limit);

	GoodReceivedNoteDTO get(Long id);

	void delete(Long id);

	GoodReceivedNoteDTO update(Long id, GoodReceivedNoteDTO dto);
}
