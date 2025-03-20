package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.PickList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;






/**
 * Spring Data repository for the PickList entity.
 */
@Repository
public interface PickListRepository extends JpaRepository<PickList, Long> {

	PickList findById(String id);

	PickList findByPicklistNumber(String picklistNumber);

}
