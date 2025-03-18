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

import com.uniquelabs.uniquedms.exceptions.ResourceAlreadyExistsException;
import com.uniquelabs.uniquedms.exceptions.ResourceNotFoundException;
import com.uniquelabs.uniquedms.io.entity.PickList;
import com.uniquelabs.uniquedms.io.entity.RouteOrder;
import com.uniquelabs.uniquedms.io.repository.PickListRepository;
import com.uniquelabs.uniquedms.io.repository.RouteOrderRepository;
import com.uniquelabs.uniquedms.service.RouteOrderService;
import com.uniquelabs.uniquedms.shared.dto.RouteOrderDTO;


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
