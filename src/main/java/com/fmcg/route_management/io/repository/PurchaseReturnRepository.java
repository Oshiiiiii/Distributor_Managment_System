package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.PurchaseReturn;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseReturnRepository extends PagingAndSortingRepository<PurchaseReturn, Long> {

	PurchaseReturn findByPurchaseReturnCode(String PurchaseReturnCode);

	PurchaseReturn findByPurchaseReturnName(String PurchaseReturnCode);

	PurchaseReturn findByPrNumber(String prNumber);

}
