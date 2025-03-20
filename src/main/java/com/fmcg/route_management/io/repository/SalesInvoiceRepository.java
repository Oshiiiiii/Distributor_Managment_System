package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.SalesInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Long> {

	SalesInvoice findBySalesInvoiceCode(String SalesInvoiceCode);

	SalesInvoice findBySalesInvoiceName(String SalesInvoiceCode);

	SalesInvoice findBySiNumber(String siNumber);



}
