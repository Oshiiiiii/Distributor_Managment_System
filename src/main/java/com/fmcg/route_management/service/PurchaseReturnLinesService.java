package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.PurchaseReturnLinesDTO;

public interface PurchaseReturnLinesService {

	PurchaseReturnLinesDTO save(PurchaseReturnLinesDTO dto);

	List<PurchaseReturnLinesDTO> getList(int page, int limit);

	PurchaseReturnLinesDTO get(Long id);

	void delete(Long id);

	PurchaseReturnLinesDTO update(Long id, PurchaseReturnLinesDTO dto);
}
