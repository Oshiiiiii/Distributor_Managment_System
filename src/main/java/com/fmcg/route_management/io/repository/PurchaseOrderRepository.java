package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.PurchaseOrder;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseOrderRepository extends PagingAndSortingRepository<PurchaseOrder, Long> {

	PurchaseOrder findByPurchaseOrderCode(String PurchaseOrderCode);

	PurchaseOrder findByPoNumber(String poNumber);

}
