package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.SalesReturn;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface SalesReturnRepository extends PagingAndSortingRepository<SalesReturn, Long> {

	SalesReturn findBySalesReturnCode(String SalesReturnCode);

	SalesReturn findBySalesReturnName(String SalesReturnCode);

}
