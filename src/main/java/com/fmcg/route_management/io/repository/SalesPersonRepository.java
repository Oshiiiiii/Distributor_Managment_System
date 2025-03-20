package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;




/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {

	SalesPerson findById(String id);

	SalesPerson findBySalesmanName(String salesmanName);

}
