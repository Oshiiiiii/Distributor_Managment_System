package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.WarehouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface WarehouseTypeRepository extends JpaRepository<WarehouseType, Long> {

	WarehouseType findById(String Id);

	WarehouseType findByTypeName(String TypeName);

}
