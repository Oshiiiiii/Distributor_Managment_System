package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.RouteOrderDTO;


public interface RouteOrderService {

	RouteOrderDTO save(RouteOrderDTO dto);

	List<RouteOrderDTO> getList(int page, int limit);

	RouteOrderDTO get(Long id);

	void delete(Long id);

	RouteOrderDTO update(Long id, RouteOrderDTO dto);
}
