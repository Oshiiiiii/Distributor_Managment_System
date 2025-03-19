package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.PurchaseOrder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseOrderRepository extends PagingAndSortingRepository<PurchaseOrder, Long> {

	PurchaseOrder findByPurchaseOrderCode(String PurchaseOrderCode);

	PurchaseOrder findByPoNumber(String poNumber);

}
