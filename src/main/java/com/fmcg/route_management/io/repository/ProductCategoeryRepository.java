package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.ProductCategoery;

/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface ProductCategoeryRepository extends PagingAndSortingRepository<ProductCategoery, Long> {

	ProductCategoery findByProductCategoryCode(String productCategoryCode);

	ProductCategoery findByProductCategoryName(String productCategoryName);

}
