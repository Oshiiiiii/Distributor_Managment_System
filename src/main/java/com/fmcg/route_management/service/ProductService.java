package com.fmcg.route_management.service;

import java.util.List;


import com.uniquelabs.uniquedms.shared.dto.ProductDTO;

public interface ProductService {

	ProductDTO save(ProductDTO dto);

	List<ProductDTO> getList(int page, int limit);

	ProductDTO get(Long id);

	void delete(Long id);

	ProductDTO update(Long id, ProductDTO dto);
}
