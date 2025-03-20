package com.fmcg.route_management.io.repository;

import com.fmcg.route_management.io.entity.GoodReceivedNoteLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Spring Data repository for the Product entity.
 */
@Repository
public interface GoodReceivedNoteLinesRepository extends JpaRepository<GoodReceivedNoteLines, Long> {

	GoodReceivedNoteLines findByGoodReceivedNoteLinesCode(String GoodReceivedNoteLinesCode);

	GoodReceivedNoteLines findByGoodReceivedNoteLinesName(String GoodReceivedNoteLinesCode);

}
