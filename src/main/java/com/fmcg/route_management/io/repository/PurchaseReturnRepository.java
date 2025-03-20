package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.PurchaseReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseReturnRepository extends JpaRepository<PurchaseReturn, Long> {

	PurchaseReturn findByPurchaseReturnCode(String PurchaseReturnCode);

	PurchaseReturn findByPurchaseReturnName(String PurchaseReturnCode);

	PurchaseReturn findByPrNumber(String prNumber);

}
