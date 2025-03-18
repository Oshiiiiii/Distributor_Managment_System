package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.SalesInvoiceLines;





/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface SalesInvoiceLinesRepository extends PagingAndSortingRepository<SalesInvoiceLines, Long> {

	SalesInvoiceLines findById(String Id);

	SalesInvoiceLines findBySalesInvoiceId(String salesInvoiceId);

}
