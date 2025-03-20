package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the Tax entity.
 */
@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {

	Tax findByTaxId(String taxId);

	Tax findByTaxDescription(String taxDescription);

}
