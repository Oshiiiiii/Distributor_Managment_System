package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.ProductDTO;

import java.util.List;


public interface ProductService {

	ProductDTO save(ProductDTO dto);

	List<ProductDTO> getList(int page, int limit);

	ProductDTO get(Long id);

	void delete(Long id);

	ProductDTO update(Long id, ProductDTO dto);
}
