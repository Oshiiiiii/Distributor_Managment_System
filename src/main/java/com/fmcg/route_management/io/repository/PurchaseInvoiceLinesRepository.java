package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.PurchaseInvoiceLines;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseInvoiceLinesRepository extends PagingAndSortingRepository<PurchaseInvoiceLines, Long> {

	PurchaseInvoiceLines findByPurchaseInvoiceLinesCode(Long purchaseInvoiceId);

	PurchaseInvoiceLines findByPurchaseInvoiceLinesName(String PurchaseInvoiceLinesCode);

}
