package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.Retailer;




/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface RetailerRepository extends PagingAndSortingRepository<Retailer, Long> {

	Retailer findByRetailerCode(String RetailerCode);

	Retailer findByRetailerName(String RetailerCode);

}
