package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.SalesOrder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;





/**
 * Spring Data repository for the Sales Order entity.
 */
@Repository
public interface SalesOrderRepository extends PagingAndSortingRepository<SalesOrder, Long> {

	SalesOrder findBySoNumber(String soNumber);

	SalesOrder findBySoDate(String soDate);

}
