package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.SalesPerson;




/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface SalesPersonRepository extends PagingAndSortingRepository<SalesPerson, Long> {

	SalesPerson findById(String id);

	SalesPerson findBySalesmanName(String salesmanName);

}
