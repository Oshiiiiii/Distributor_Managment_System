package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.ProductCategoeryDTO;

public interface ProductCategoeryService {

	ProductCategoeryDTO save(ProductCategoeryDTO dto);

	List<ProductCategoeryDTO> getList(int page, int limit);

	ProductCategoeryDTO get(Long id);

	void delete(Long id);

	ProductCategoeryDTO update(Long id, ProductCategoeryDTO dto);
}
