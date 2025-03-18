package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.PurchaseOrderLinesDTO;

public interface PurchaseOrderLinesService {

	PurchaseOrderLinesDTO save(PurchaseOrderLinesDTO dto);

	List<PurchaseOrderLinesDTO> getList(int page, int limit);

	PurchaseOrderLinesDTO get(Long id);

	void delete(Long id);

	PurchaseOrderLinesDTO update(Long id, PurchaseOrderLinesDTO dto);
}
