package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.PurchaseInvoice;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseInvoiceRepository extends PagingAndSortingRepository<PurchaseInvoice, Long> {

	PurchaseInvoice findByPurchaseInvoiceCode(String PurchaseInvoiceCode);

	PurchaseInvoice findByPurchaseInvoiceName(String PurchaseInvoiceCode);

	PurchaseInvoice findByPiNumber(String piNumber);

}
