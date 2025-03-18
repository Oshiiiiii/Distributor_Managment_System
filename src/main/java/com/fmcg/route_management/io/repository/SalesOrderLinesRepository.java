package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.SalesOrderLines;



/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface SalesOrderLinesRepository extends PagingAndSortingRepository<SalesOrderLines, Long> {

	SalesOrderLines findById(String Id);

	SalesOrderLines findBySalesOrderId(String salesOrderId);

}
