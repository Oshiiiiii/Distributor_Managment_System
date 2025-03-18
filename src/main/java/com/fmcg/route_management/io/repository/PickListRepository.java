package com.fmcg.route_management.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquelabs.uniquedms.io.entity.PickList;




/**
 * Spring Data repository for the PickList entity.
 */
@Repository
public interface PickListRepository extends PagingAndSortingRepository<PickList, Long> {

	PickList findById(String id);

	PickList findByPicklistNumber(String picklistNumber);

}
