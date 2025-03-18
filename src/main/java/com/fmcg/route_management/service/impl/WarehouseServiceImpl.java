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
import com.uniquelabs.uniquedms.io.entity.Warehouse;
import com.uniquelabs.uniquedms.io.entity.WarehouseType;
import com.uniquelabs.uniquedms.io.repository.WarehouseRepository;
import com.uniquelabs.uniquedms.io.repository.WarehouseTypeRepository;
import com.uniquelabs.uniquedms.service.WarehouseService;
import com.uniquelabs.uniquedms.shared.dto.WarehouseDTO;



@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	WarehouseRepository repository;
	
	@Autowired
	WarehouseTypeRepository warehouseTypeRepository;

	@Override
	public WarehouseDTO save(WarehouseDTO dto) {

		if (repository.findByWharehouseCode(dto.getWarehouseCode()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		Warehouse entity = mapper.map(dto,Warehouse.class);
		Warehouse storage = repository.save(entity);

		return mapper.map(storage, WarehouseDTO.class);
	}

	@Override
	public List<WarehouseDTO> getList(int page, int limit) {
		List<WarehouseDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Warehouse> resourcePage = repository.findAll(pageableRequest);
		List<Warehouse> resource = resourcePage.getContent();

		for (Warehouse entity : resource) {
			returnValue.add(mapper.map(entity, WarehouseDTO.class));
		}

		return returnValue;
	}

	@Override
	public WarehouseDTO get(Long id) {
		Optional<Warehouse> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), WarehouseDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Warehouse is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Warehouse> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Warehouse  is not found.");
		}
	}

	@Override
	public WarehouseDTO update(Long id, WarehouseDTO dto) {

		Optional<Warehouse> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setWarehouseCode(dto.getWarehouseCode());
			entity.get().setWarehouseName(dto.getWarehouseName());
			entity.get().setDescription(dto.getDescription());
			entity.get().setAddress(dto.getAddress());
			entity.get().setStatus(dto.getStatus());
			
			Optional<WarehouseType> warehouseType = warehouseTypeRepository.findById(id);
			if (warehouseType.isPresent()) {
				entity.get().setWarehouseType(warehouseType.get());
			}else {
				throw new ResourceNotFoundException("Requested warehouse type is not found.");
			}
			Warehouse updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, WarehouseDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Warehouse is not found.");
		}

	}

}
