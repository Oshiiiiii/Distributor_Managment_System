package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.GoodReceivedNote;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface GoodReceivedNoteRepository extends PagingAndSortingRepository<GoodReceivedNote, Long> {

	GoodReceivedNote findBygrnNumber(String grnNumbere);

	GoodReceivedNote findByGoodReceivedNoteName(String GoodReceivedNoteCode);

}
