package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.PurchaseOrderLines;
import com.fmcg.route_management.io.repository.PurchaseOrderLinesRepository;
import com.fmcg.route_management.service.PurchaseOrderLinesService;
import com.fmcg.route_management.shared.dto.PurchaseOrderLinesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PurchaseOrderLinesServiceImpl implements PurchaseOrderLinesService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PurchaseOrderLinesRepository repository;

	@Override
	public PurchaseOrderLinesDTO save(PurchaseOrderLinesDTO dto) {


		PurchaseOrderLines entity = mapper.map(dto, PurchaseOrderLines.class);
		PurchaseOrderLines storage = repository.save(entity);

		return mapper.map(storage, PurchaseOrderLinesDTO.class);
	}

	@Override
	public List<PurchaseOrderLinesDTO> getList(int page, int limit) {
		List<PurchaseOrderLinesDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<PurchaseOrderLines> resourcePage = repository.findAll(pageableRequest);
		List<PurchaseOrderLines> resource = resourcePage.getContent();

		for (PurchaseOrderLines entity : resource) {
			returnValue.add(mapper.map(entity, PurchaseOrderLinesDTO.class));
		}

		return returnValue;
	}

	@Override
	public PurchaseOrderLinesDTO get(Long id) {
		Optional<PurchaseOrderLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), PurchaseOrderLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseOrderLines is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<PurchaseOrderLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested PurchaseOrderLines  is not found.");
		}
	}

	@Override
	public PurchaseOrderLinesDTO update(Long id, PurchaseOrderLinesDTO dto) {

		Optional<PurchaseOrderLines> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductQty(dto.getProductQty());
			entity.get().setPrimaryPrice(dto.getPrimaryPrice());
			PurchaseOrderLines updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, PurchaseOrderLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseOrderLines is not found.");
		}

	}

}
