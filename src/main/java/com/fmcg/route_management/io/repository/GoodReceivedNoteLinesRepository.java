package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.GoodReceivedNoteLines;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface GoodReceivedNoteLinesRepository extends PagingAndSortingRepository<GoodReceivedNoteLines, Long> {

	GoodReceivedNoteLines findByGoodReceivedNoteLinesCode(String GoodReceivedNoteLinesCode);

	GoodReceivedNoteLines findByGoodReceivedNoteLinesName(String GoodReceivedNoteLinesCode);

}
