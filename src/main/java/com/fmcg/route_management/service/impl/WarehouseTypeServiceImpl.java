package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.WarehouseType;
import com.fmcg.route_management.io.repository.WarehouseTypeRepository;
import com.fmcg.route_management.service.WarehouseTypeService;
import com.fmcg.route_management.shared.dto.WarehouseTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class WarehouseTypeServiceImpl implements WarehouseTypeService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	WarehouseTypeRepository repository;

	@Override
	public WarehouseTypeDTO save(WarehouseTypeDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		 WarehouseType entity = mapper.map(dto,  WarehouseType.class);
		 WarehouseType storage = repository.save(entity);

		return mapper.map(storage, WarehouseTypeDTO.class);
	}

	@Override
	public List<WarehouseTypeDTO> getList(int page, int limit) {
		List<WarehouseTypeDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<WarehouseType> resourcePage = repository.findAll(pageableRequest);
		List<WarehouseType> resource = resourcePage.getContent();

		for (WarehouseType entity : resource) {
			returnValue.add(mapper.map(entity, WarehouseTypeDTO.class));
		}

		return returnValue;
	}

	@Override
	public WarehouseTypeDTO get(Long id) {
		Optional<WarehouseType> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), WarehouseTypeDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Warehouse Type is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<WarehouseType> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Warehouse Type is not found.");
		}
	}

	@Override
	public WarehouseTypeDTO update(Long id, WarehouseTypeDTO dto) {

		Optional<WarehouseType> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setTypeDescription(dto.getTypeDescription());
			entity.get().setTypeName(dto.getTypeName());
			entity.get().setStatus(dto.getStatus());
			WarehouseType updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, WarehouseTypeDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Warehouse Type is not found.");
		}

	}

}
