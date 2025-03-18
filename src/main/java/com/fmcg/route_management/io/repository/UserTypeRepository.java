package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.UserType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;




/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface UserTypeRepository extends PagingAndSortingRepository<UserType, Long> {

	UserType findByUserTypeCode(String UserTypeCode);

	UserType findByUserTypeName(String UserTypeName);

}
