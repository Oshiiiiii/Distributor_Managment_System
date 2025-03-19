package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUserCode(String UserCode);

	User findByUserName(String UserName);

}
