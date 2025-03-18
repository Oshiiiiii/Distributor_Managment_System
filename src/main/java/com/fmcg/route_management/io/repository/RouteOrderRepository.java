package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.RouteOrder;



/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface RouteOrderRepository extends PagingAndSortingRepository<RouteOrder, Long> {

	RouteOrder findById(String Id);

	RouteOrder findByOrderNo(String orderNo);

}
