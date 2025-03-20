package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Long> {

	PurchaseInvoice findByPurchaseInvoiceCode(String PurchaseInvoiceCode);

	PurchaseInvoice findByPurchaseInvoiceName(String PurchaseInvoiceCode);

	PurchaseInvoice findByPiNumber(String piNumber);

}
