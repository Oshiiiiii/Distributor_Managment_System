package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.SalesOrder;
import com.fmcg.route_management.io.entity.SalesOrderLines;
import com.fmcg.route_management.io.repository.SalesOrderLinesRepository;
import com.fmcg.route_management.io.repository.SalesOrderRepository;
import com.fmcg.route_management.service.SalesOrderLinesService;
import com.fmcg.route_management.shared.dto.SalesOrderLinesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesOrderLinesServiceImpl implements SalesOrderLinesService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	SalesOrderLinesRepository repository;
	
	@Autowired
	SalesOrderRepository salesOrderRepository;

	@Override
	public SalesOrderLinesDTO save(SalesOrderLinesDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		SalesOrderLines entity = mapper.map(dto, SalesOrderLines.class);
		SalesOrderLines storage = repository.save(entity);

		return mapper.map(storage, SalesOrderLinesDTO.class);
	}

	@Override
	public List<SalesOrderLinesDTO> getList(int page, int limit) {
		List<SalesOrderLinesDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<SalesOrderLines> resourcePage = repository.findAll(pageableRequest);
		List<SalesOrderLines> resource = resourcePage.getContent();

		for (SalesOrderLines entity : resource) {
			returnValue.add(mapper.map(entity, SalesOrderLinesDTO.class));
		}

		return returnValue;
	}

	@Override
	public SalesOrderLinesDTO get(Long id) {
		Optional<SalesOrderLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), SalesOrderLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested product Sales Order Line is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<SalesOrderLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Sales Order Line is not found.");
		}
	}

	@Override
	public SalesOrderLinesDTO update(Long id, SalesOrderLinesDTO dto) {

		Optional<SalesOrderLines> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductQty(dto.getProductQty());
			
			Optional<SalesOrder> salesOrder = salesOrderRepository.findById(id);
			if (salesOrder.isPresent()) {
				entity.get().setSalesOrder(salesOrder.get());
			} else {
				throw new ResourceNotFoundException("Selected Sales order no is not found.");
			}
			
			SalesOrderLines updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, SalesOrderLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Order Line is not found.");
		}

	}

}
