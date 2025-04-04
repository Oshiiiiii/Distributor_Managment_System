package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.PurchaseReturnLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseReturnLinesRepository extends JpaRepository<PurchaseReturnLines, Long> {

	PurchaseReturnLines findByPurchaseReturnLinesLinesLinesCode(String PurchaseReturnLinesCode);

	PurchaseReturnLines findByPurchaseReturnLinesLinesLinesName(String PurchaseReturnLinesCode);

}
