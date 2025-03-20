package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

	Warehouse findByWharehouseCode(String WharehouseCode);

	Warehouse findByWharehouseName(String WharehouseCode);

}
