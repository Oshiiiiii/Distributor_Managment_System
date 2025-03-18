package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.Product;

/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	Product findByProductCode(String productCode);

	Product findByProductName(String productName);

}
