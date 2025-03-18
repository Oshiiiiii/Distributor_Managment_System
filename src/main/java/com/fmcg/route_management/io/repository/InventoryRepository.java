package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.Inventory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface InventoryRepository extends PagingAndSortingRepository<Inventory, Long> {

	Inventory findByInventoryCode(String InventoryCode);

	Inventory findByInventoryName(String InventoryCode);

}
