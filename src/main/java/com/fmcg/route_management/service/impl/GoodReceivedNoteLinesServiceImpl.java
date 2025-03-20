package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.GoodReceivedNoteLines;
import com.fmcg.route_management.io.repository.GoodReceivedNoteLinesRepository;
import com.fmcg.route_management.service.GoodReceivedNoteLinesService;
import com.fmcg.route_management.shared.dto.GoodReceivedNoteLinesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;





@Service
public class GoodReceivedNoteLinesServiceImpl implements GoodReceivedNoteLinesService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	GoodReceivedNoteLinesRepository repository;

	@Override
	public GoodReceivedNoteLinesDTO save(GoodReceivedNoteLinesDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		GoodReceivedNoteLines entity = mapper.map(dto, GoodReceivedNoteLines.class);
		GoodReceivedNoteLines storage = repository.save(entity);

		return mapper.map(storage, GoodReceivedNoteLinesDTO.class);
	}

	@Override
	public List<GoodReceivedNoteLinesDTO> getList(int page, int limit) {
		List<GoodReceivedNoteLinesDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<GoodReceivedNoteLines> resourcePage = repository.findAll(pageableRequest);
		List<GoodReceivedNoteLines> resource = resourcePage.getContent();

		for (GoodReceivedNoteLines entity : resource) {
			returnValue.add(mapper.map(entity, GoodReceivedNoteLinesDTO.class));
		}

		return returnValue;
	}

	@Override
	public GoodReceivedNoteLinesDTO get(Long id) {
		Optional<GoodReceivedNoteLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), GoodReceivedNoteLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested GoodReceivedNoteLines is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<GoodReceivedNoteLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested GoodReceivedNoteLines  is not found.");
		}
	}

	@Override
	public GoodReceivedNoteLinesDTO update(Long id, GoodReceivedNoteLinesDTO dto) {

		Optional<GoodReceivedNoteLines> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductGrnQty(dto.getProductGrnQty());
			entity.get().setProductDifferenceQty(dto.getProductDifferenceQty());
			entity.get().setReason(dto.getReason());
			GoodReceivedNoteLines updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, GoodReceivedNoteLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested GoodReceivedNoteLines is not found.");
		}

	}

}
