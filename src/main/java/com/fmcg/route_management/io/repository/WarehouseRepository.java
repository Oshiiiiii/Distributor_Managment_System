package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.Warehouse;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, Long> {

	Warehouse findByWharehouseCode(String WharehouseCode);

	Warehouse findByWharehouseName(String WharehouseCode);

}
