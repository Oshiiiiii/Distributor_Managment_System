package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.RouteOrderDTO;

import java.util.List;


public interface RouteOrderService {

	RouteOrderDTO save(RouteOrderDTO dto);

	List<RouteOrderDTO> getList(int page, int limit);

	RouteOrderDTO get(Long id);

	void delete(Long id);

	RouteOrderDTO update(Long id, RouteOrderDTO dto);
}
