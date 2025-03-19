package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.SalesReturnLines;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface SalesReturnLinesRepository extends PagingAndSortingRepository<SalesReturnLines, Long> {

	SalesReturnLines findById(String Id);

	SalesReturnLines findBySalesReturnId(String salesReturnId);

}
