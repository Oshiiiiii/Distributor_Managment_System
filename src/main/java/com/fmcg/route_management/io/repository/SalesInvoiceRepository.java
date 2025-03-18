package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.SalesInvoice;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface SalesInvoiceRepository extends PagingAndSortingRepository<SalesInvoice, Long> {

	SalesInvoice findBySalesInvoiceCode(String SalesInvoiceCode);

	SalesInvoice findBySalesInvoiceName(String SalesInvoiceCode);

	SalesInvoice findBySiNumber(String siNumber);



}
