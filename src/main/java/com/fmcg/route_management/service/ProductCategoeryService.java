package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.ProductCategoeryDTO;

import java.util.List;


public interface ProductCategoeryService {

	ProductCategoeryDTO save(ProductCategoeryDTO dto);

	List<ProductCategoeryDTO> getList(int page, int limit);

	ProductCategoeryDTO get(Long id);

	void delete(Long id);

	ProductCategoeryDTO update(Long id, ProductCategoeryDTO dto);
}
