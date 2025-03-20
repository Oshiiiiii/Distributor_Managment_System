package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;






/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long> {

	Retailer findByRetailerCode(String RetailerCode);

	Retailer findByRetailerName(String RetailerCode);

}
