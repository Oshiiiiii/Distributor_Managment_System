package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.RouteOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;




/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface RouteOrderRepository extends JpaRepository<RouteOrder, Long> {

	RouteOrder findById(String Id);

	RouteOrder findByOrderNo(String orderNo);

}
