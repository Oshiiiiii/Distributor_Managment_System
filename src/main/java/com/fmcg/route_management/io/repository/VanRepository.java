package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.Van;



/**
 * Spring Data repository for the ProductCategoery entity.
 */
@Repository
public interface VanRepository extends PagingAndSortingRepository<Van, Long> {

	Van findByVanCode(String VanCode);

	Van findByVanName(String VanName);

}
