package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.SalesReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface SalesReturnRepository extends JpaRepository<SalesReturn, Long> {

	SalesReturn findBySalesReturnCode(String SalesReturnCode);

	SalesReturn findBySalesReturnName(String SalesReturnCode);

}
