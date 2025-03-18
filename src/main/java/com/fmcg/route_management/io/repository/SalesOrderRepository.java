package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.SalesOrder;




/**
 * Spring Data repository for the Sales Order entity.
 */
@Repository
public interface SalesOrderRepository extends PagingAndSortingRepository<SalesOrder, Long> {

	SalesOrder findBySoNumber(String soNumber);

	SalesOrder findBySoDate(String soDate);

}
