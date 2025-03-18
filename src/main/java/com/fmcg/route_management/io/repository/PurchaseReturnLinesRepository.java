package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.PurchaseReturnLines;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseReturnLinesRepository extends PagingAndSortingRepository<PurchaseReturnLines, Long> {

	PurchaseReturnLines findByPurchaseReturnLinesLinesLinesCode(String PurchaseReturnLinesCode);

	PurchaseReturnLines findByPurchaseReturnLinesLinesLinesName(String PurchaseReturnLinesCode);

}
