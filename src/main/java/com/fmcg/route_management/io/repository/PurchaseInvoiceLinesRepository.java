package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.PurchaseInvoiceLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseInvoiceLinesRepository extends JpaRepository<PurchaseInvoiceLines, Long> {

	PurchaseInvoiceLines findByPurchaseInvoiceLinesCode(Long purchaseInvoiceId);

	PurchaseInvoiceLines findByPurchaseInvoiceLinesName(String PurchaseInvoiceLinesCode);

}
