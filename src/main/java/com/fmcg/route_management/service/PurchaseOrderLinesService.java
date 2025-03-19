package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.PurchaseOrderLinesDTO;

import java.util.List;


public interface PurchaseOrderLinesService {

	PurchaseOrderLinesDTO save(PurchaseOrderLinesDTO dto);

	List<PurchaseOrderLinesDTO> getList(int page, int limit);

	PurchaseOrderLinesDTO get(Long id);

	void delete(Long id);

	PurchaseOrderLinesDTO update(Long id, PurchaseOrderLinesDTO dto);
}
