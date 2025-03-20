package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

	Distributor findByDistributorCode(String distributorCode);

	Distributor findByDistributorName(String distributorCode);

}
