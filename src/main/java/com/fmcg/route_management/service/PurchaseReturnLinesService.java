package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.PurchaseReturnLinesDTO;

import java.util.List;


public interface PurchaseReturnLinesService {

	PurchaseReturnLinesDTO save(PurchaseReturnLinesDTO dto);

	List<PurchaseReturnLinesDTO> getList(int page, int limit);

	PurchaseReturnLinesDTO get(Long id);

	void delete(Long id);

	PurchaseReturnLinesDTO update(Long id, PurchaseReturnLinesDTO dto);
}
