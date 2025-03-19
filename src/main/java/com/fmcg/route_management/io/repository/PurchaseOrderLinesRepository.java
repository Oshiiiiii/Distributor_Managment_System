package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.PurchaseOrderLines;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseOrderLinesRepository extends PagingAndSortingRepository<PurchaseOrderLines, Long> {

	PurchaseOrderLines findByPurchaseOrderLinesCode(String PurchaseOrderLinesCode);

	PurchaseOrderLines findByPurchaseOrderLinesName(String PurchaseOrderLinesCode);

}
