package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.SalesOrder;
import com.fmcg.route_management.io.repository.SalesOrderRepository;
import com.fmcg.route_management.service.SalesOrderService;
import com.fmcg.route_management.shared.dto.SalesOrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	SalesOrderRepository repository;

	@Override
	public SalesOrderDTO save(SalesOrderDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		SalesOrder entity = mapper.map(dto, SalesOrder.class);
		SalesOrder storage = repository.save(entity);

		return mapper.map(storage, SalesOrderDTO.class);
	}

	@Override
	public List<SalesOrderDTO> getList(int page, int limit) {
		List<SalesOrderDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<SalesOrder> resourcePage = repository.findAll(pageableRequest);
		List<SalesOrder> resource = resourcePage.getContent();

		for (SalesOrder entity : resource) {
			returnValue.add(mapper.map(entity, SalesOrderDTO.class));
		}

		return returnValue;
	}

	@Override
	public SalesOrderDTO get(Long id) {
		Optional<SalesOrder> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), SalesOrderDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Order is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<SalesOrder> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Sales Order is not found.");
		}
	}

	@Override
	public SalesOrderDTO update(Long id, SalesOrderDTO dto) {

		Optional<SalesOrder> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setSoNumber(dto.getSoNumber());
			entity.get().setSoDate(dto.getSoDate());
			entity.get().setDeliveryDate(dto.getDeliveryDate());
			entity.get().setTotalValueExluded(dto.getTotalValueExluded());
			entity.get().setTotalValueIncluded(dto.getTotalValueIncluded());
			entity.get().setRemarks(dto.getRemarks());;
			entity.get().setTotalValueIncluded(dto.getTotalValueIncluded());
			entity.get().setStatus(dto.getStatus());
			SalesOrder updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, SalesOrderDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Tax is not found.");
		}

	}

}
