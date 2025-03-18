package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.uniquelabs.uniquedms.io.entity.WarehouseType;

/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface WarehouseTypeRepository extends PagingAndSortingRepository<WarehouseType, Long> {

	WarehouseType findById(String Id);

	WarehouseType findByTypeName(String TypeName);

}
