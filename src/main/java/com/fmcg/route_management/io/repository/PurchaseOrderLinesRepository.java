package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.PurchaseOrderLines;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseOrderLinesRepository extends PagingAndSortingRepository<PurchaseOrderLines, Long> {

	PurchaseOrderLines findByPurchaseOrderLinesCode(String PurchaseOrderLinesCode);

	PurchaseOrderLines findByPurchaseOrderLinesName(String PurchaseOrderLinesCode);

}
