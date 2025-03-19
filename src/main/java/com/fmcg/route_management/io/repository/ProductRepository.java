package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	Product findByProductCode(String productCode);

	Product findByProductName(String productName);

}
