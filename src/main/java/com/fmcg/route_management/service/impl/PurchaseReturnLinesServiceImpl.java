package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniquelabs.uniquedms.exceptions.ResourceNotFoundException;
import com.uniquelabs.uniquedms.io.entity.PurchaseReturnLines;
import com.uniquelabs.uniquedms.io.repository.PurchaseReturnLinesRepository;
import com.uniquelabs.uniquedms.service.PurchaseReturnLinesService;
import com.uniquelabs.uniquedms.shared.dto.PurchaseReturnLinesDTO;



@Service
public class PurchaseReturnLinesServiceImpl implements PurchaseReturnLinesService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PurchaseReturnLinesRepository repository;

	@Override
	public PurchaseReturnLinesDTO save(PurchaseReturnLinesDTO dto) {

		PurchaseReturnLines entity = mapper.map(dto, PurchaseReturnLines.class);
		PurchaseReturnLines storage = repository.save(entity);

		return mapper.map(storage, PurchaseReturnLinesDTO.class);
	}

	@Override
	public List<PurchaseReturnLinesDTO> getList(int page, int limit) {
		List<PurchaseReturnLinesDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<PurchaseReturnLines> resourcePage = repository.findAll(pageableRequest);
		List<PurchaseReturnLines> resource = resourcePage.getContent();

		for (PurchaseReturnLines entity : resource) {
			returnValue.add(mapper.map(entity, PurchaseReturnLinesDTO.class));
		}

		return returnValue;
	}

	@Override
	public PurchaseReturnLinesDTO get(Long id) {
		Optional<PurchaseReturnLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), PurchaseReturnLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseReturnLines is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<PurchaseReturnLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested PurchaseReturnLines  is not found.");
		}
	}

	@Override
	public PurchaseReturnLinesDTO update(Long id, PurchaseReturnLinesDTO dto) {

		Optional<PurchaseReturnLines> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductReturnQty(dto.getProductReturnQty());
			PurchaseReturnLines updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, PurchaseReturnLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseReturnLines is not found.");
		}

	}

}
