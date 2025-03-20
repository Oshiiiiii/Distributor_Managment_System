package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.Van;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface VanRepository extends JpaRepository<Van, Long> {

	Van findByVanCode(String VanCode);

	Van findByVanName(String VanName);

}
