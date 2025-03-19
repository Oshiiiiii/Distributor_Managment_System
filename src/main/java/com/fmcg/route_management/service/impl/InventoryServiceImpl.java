package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.Inventory;
import com.fmcg.route_management.io.repository.InventoryRepository;
import com.fmcg.route_management.service.InventoryService;
import com.fmcg.route_management.shared.dto.InventoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	InventoryRepository repository;

	@Override
	public InventoryDTO save(InventoryDTO dto) {

		if (repository.findById(dto.getProductId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		Inventory entity = mapper.map(dto, Inventory.class);
		Inventory storage = repository.save(entity);

		return mapper.map(storage, InventoryDTO.class);
	}

	@Override
	public List<InventoryDTO> getList(int page, int limit) {
		List<InventoryDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Inventory> resourcePage = repository.findAll(pageableRequest);
		List<Inventory> resource = resourcePage.getContent();

		for (Inventory entity : resource) {
			returnValue.add(mapper.map(entity, InventoryDTO.class));
		}

		return returnValue;
	}

	@Override
	public InventoryDTO get(Long id) {
		Optional<Inventory> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), InventoryDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Inventory is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Inventory> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Inventory  is not found.");
		}
	}

	@Override
	public InventoryDTO update(Long id, InventoryDTO dto) {

		Optional<Inventory> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setAvailableQty(dto.getAvailableQty());
			entity.get().setProductValueExcluded(dto.getProductValueExcluded());
			entity.get().setProductValueIncluded(dto.getProductValueIncluded());
			Inventory updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, InventoryDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Inventory is not found.");
		}

	}

}
