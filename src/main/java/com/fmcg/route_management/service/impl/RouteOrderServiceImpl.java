package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.PickList;
import com.fmcg.route_management.io.entity.RouteOrder;
import com.fmcg.route_management.io.repository.PickListRepository;
import com.fmcg.route_management.io.repository.RouteOrderRepository;
import com.fmcg.route_management.service.RouteOrderService;
import com.fmcg.route_management.shared.dto.RouteOrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RouteOrderServiceImpl implements RouteOrderService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	RouteOrderRepository repository;
	
	@Autowired
	PickListRepository pickListRepository;

	@Override
	public RouteOrderDTO save(RouteOrderDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		RouteOrder entity = mapper.map(dto, RouteOrder.class);
		RouteOrder storage = repository.save(entity);

		return mapper.map(storage, RouteOrderDTO.class);
	}

	@Override
	public List<RouteOrderDTO> getList(int page, int limit) {
		List<RouteOrderDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<RouteOrder> resourcePage = repository.findAll(pageableRequest);
		List<RouteOrder> resource = resourcePage.getContent();

		for (RouteOrder entity : resource) {
			returnValue.add(mapper.map(entity, RouteOrderDTO.class));
		}

		return returnValue;
	}

	@Override
	public RouteOrderDTO get(Long id) {
		Optional<RouteOrder> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), RouteOrderDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Route Order is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<RouteOrder> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Route Order is not found.");
		}
	}

	@Override
	public RouteOrderDTO update(Long id, RouteOrderDTO dto) {

		Optional<RouteOrder> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setOrderNo(dto.getOrderNo());
			
			Optional<PickList> pickList = pickListRepository.findById(id);
			if (pickList.isPresent()) {
				entity.get().setPickList(pickList.get());
			} else {
				throw new ResourceNotFoundException("Selected picklist is not found.");
			}
			RouteOrder updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, RouteOrderDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Route Order is not found.");
		}

	}

}
