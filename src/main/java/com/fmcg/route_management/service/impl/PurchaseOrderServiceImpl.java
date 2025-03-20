package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.PurchaseOrder;
import com.fmcg.route_management.io.repository.PurchaseOrderRepository;
import com.fmcg.route_management.service.PurchaseOrderService;
import com.fmcg.route_management.shared.dto.PurchaseOrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PurchaseOrderRepository repository;

	@Override
	public PurchaseOrderDTO save(PurchaseOrderDTO dto) {

		if (repository.findByPoNumber(dto.getPoNumber()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		PurchaseOrder entity = mapper.map(dto, PurchaseOrder.class);
		PurchaseOrder storage = repository.save(entity);

		return mapper.map(storage, PurchaseOrderDTO.class);
	}

	@Override
	public List<PurchaseOrderDTO> getList(int page, int limit) {
		List<PurchaseOrderDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<PurchaseOrder> resourcePage = repository.findAll(pageableRequest);
		List<PurchaseOrder> resource = resourcePage.getContent();

		for (PurchaseOrder entity : resource) {
			returnValue.add(mapper.map(entity, PurchaseOrderDTO.class));
		}

		return returnValue;
	}

	@Override
	public PurchaseOrderDTO get(Long id) {
		Optional<PurchaseOrder> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), PurchaseOrderDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseOrder is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<PurchaseOrder> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested PurchaseOrder  is not found.");
		}
	}

	@Override
	public PurchaseOrderDTO update(Long id, PurchaseOrderDTO dto) {

		Optional<PurchaseOrder> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setPoNumber(dto.getPoNumber());
			entity.get().setPoDate(dto.getPoDate());
			entity.get().setDeliveryDate(dto.getDeliveryDate());
			entity.get().setTotalValueExcluded(dto.getTotalValueExcluded());
			entity.get().setTotalValueIncluded(dto.getTotalValueIncluded());
			entity.get().setRemarks(dto.getRemarks());
			entity.get().setStatus(dto.getStatus());
			PurchaseOrder updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, PurchaseOrderDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseOrder is not found.");
		}

	}

}
