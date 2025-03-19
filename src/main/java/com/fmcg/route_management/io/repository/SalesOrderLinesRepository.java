package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.SalesOrderLines;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;




/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface SalesOrderLinesRepository extends PagingAndSortingRepository<SalesOrderLines, Long> {

	SalesOrderLines findById(String Id);

	SalesOrderLines findBySalesOrderId(String salesOrderId);

}
